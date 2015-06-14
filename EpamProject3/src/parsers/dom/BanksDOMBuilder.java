package parsers.dom;

import entity.Bank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.builder.AbstractBanksBuilder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by oleg on 12.06.15.
 */
public class BanksDOMBuilder extends AbstractBanksBuilder {
    private DocumentBuilder documentBuilder;

    public BanksDOMBuilder(){
        banks = new HashSet<Bank>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void buildBanksSet(String fileName) {
        Document document = null;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList banksList = root.getElementsByTagName("bank");
            for (int i = 0; i < banksList.getLength(); i++) {
                Element bankElement = (Element) banksList.item(i);
                Bank bank = buildBank(bankElement);
                banks.add(bank);
            }
        } catch (SAXException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private Bank buildBank(Element bankElement) {
        Bank currentBank = new Bank();
        DatatypeFactory datatypeFactory = null;
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            System.err.println(e.getMessage());
        }
        currentBank.setName(getElementTextValue(bankElement,"name"));
        currentBank.setCountry(getElementTextValue(bankElement,"country"));
        Bank.Deposit currenDeposit = currentBank.getDeposit();
        Element depositElement = (Element)bankElement.getElementsByTagName("deposit").item(0);
        currenDeposit.setDepositor(getElementTextValue(depositElement, "depositor"));
        currenDeposit.setAmount(Double.parseDouble(getElementTextValue(depositElement, "amount")));
        currenDeposit.setProfitability(Double.parseDouble(getElementTextValue(depositElement, "profitability")));
        currenDeposit.setConstraints(datatypeFactory.newDuration(getElementTextValue(depositElement, "constraints")));
        currenDeposit.setType(depositElement.getAttribute("type"));
        currenDeposit.setAccountId(depositElement.getAttribute("accountId"));
        return currentBank;
    }

    private static String getElementTextValue(Element bankElement, String elementName) {
        return bankElement.getElementsByTagName(elementName).item(0).getTextContent();
    }
}
