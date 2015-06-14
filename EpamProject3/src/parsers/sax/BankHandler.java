package parsers.sax;

import entity.Bank;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import parsers.builder.BankEnum;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oleg on 12.06.15.
 */
public class BankHandler extends DefaultHandler {
    private Set<Bank> banks;
    private Bank bank;
    private BankEnum currentEnum;
    private EnumSet<BankEnum> elementsWithText;

    public BankHandler() {
        banks = new HashSet<Bank>();
        elementsWithText = EnumSet.range(BankEnum.NAME, BankEnum.CONSTRAINTS);
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("bank")) {
            bank = new Bank();
        } else if (localName.equals("deposit")) {
            bank.getDeposit().setType(attributes.getValue(0));
            bank.getDeposit().setAccountId(attributes.getValue(1));
        } else {
            BankEnum temp = BankEnum.valueOf(localName.toUpperCase());
            if (elementsWithText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("bank")) {
            banks.add(bank);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        DatatypeFactory datatypeFactory = null;
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            System.err.println(e.getMessage());
        }
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    bank.setName(s);
                    break;
                case COUNTRY:
                    bank.setCountry(s);
                    break;
                case DEPOSITOR:
                    bank.getDeposit().setDepositor(s);
                    break;
                case AMOUNT:
                    bank.getDeposit().setAmount(Double.parseDouble(s));
                    break;
                case PROFITABILITY:
                    bank.getDeposit().setProfitability(Double.parseDouble(s));
                    break;
                case CONSTRAINTS:
                    bank.getDeposit().setConstraints(datatypeFactory.newDuration(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());

            }
        }
        currentEnum = null;
    }
}
