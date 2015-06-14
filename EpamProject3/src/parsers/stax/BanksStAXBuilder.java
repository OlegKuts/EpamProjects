package parsers.stax;

import entity.Bank;
import parsers.builder.AbstractBanksBuilder;
import parsers.builder.BankEnum;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by oleg on 13.06.15.
 */
public class BanksStAXBuilder extends AbstractBanksBuilder {
    private XMLInputFactory inputFactory;

    public BanksStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildBanksSet(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (BankEnum.valueOf(name.toUpperCase()) == BankEnum.BANK) {
                        Bank bank = buildBank(reader);
                        banks.add(bank);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (XMLStreamException e) {
            System.err.println(e.getMessage());
        } catch (DatatypeConfigurationException e) {
            System.err.println(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Bank buildBank(XMLStreamReader reader) throws XMLStreamException, DatatypeConfigurationException {
        Bank bank = new Bank();
        String name;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (BankEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            bank.setName(getXMLText(reader));
                            break;
                        case COUNTRY:
                            bank.setCountry(getXMLText(reader));
                            break;
                        case DEPOSIT:
                            bank.setDeposit(getXMLDeposit(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (BankEnum.valueOf(name.toUpperCase()) == BankEnum.BANK) {
                        return bank;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in Bank tag");
    }

    private static Bank.Deposit getXMLDeposit(XMLStreamReader reader) throws XMLStreamException, DatatypeConfigurationException {
        Bank.Deposit deposit = new Bank.Deposit();
        String name = null;
        int type;
        DatatypeFactory factory = DatatypeFactory.newInstance();
        deposit.setType(reader.getAttributeValue(null, BankEnum.TYPE.getValue()));
        deposit.setAccountId(reader.getAttributeValue(null, BankEnum.ACCOUNTID.getValue()));
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (BankEnum.valueOf(name.toUpperCase())) {
                        case DEPOSITOR:
                            deposit.setDepositor(getXMLText(reader));
                            break;
                        case AMOUNT:
                            deposit.setAmount(Double.parseDouble(getXMLText(reader)));
                            break;
                        case PROFITABILITY:
                            deposit.setProfitability(Double.parseDouble(getXMLText(reader)));
                            break;
                        case CONSTRAINTS:
                            deposit.setConstraints(factory.newDuration(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (BankEnum.valueOf(name.toUpperCase()) == BankEnum.DEPOSIT) {
                        return deposit;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in Deposit tag");
    }

    private static String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
