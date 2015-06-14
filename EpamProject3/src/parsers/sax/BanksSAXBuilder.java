package parsers.sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import parsers.builder.AbstractBanksBuilder;

import java.io.IOException;

/**
 * Created by oleg on 12.06.15.
 */
public class BanksSAXBuilder extends AbstractBanksBuilder {
    private BankHandler bh;
    private XMLReader reader;

    public BanksSAXBuilder() {
        bh = new BankHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(bh);
        } catch (SAXException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buildBanksSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (SAXException e) {
            System.err.println(e.getMessage());
        }
        banks = bh.getBanks();
    }
}
