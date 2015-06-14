package validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by oleg on 12.06.15.
 */
public class SAXValidator {
    public static void main(String[] args){
        String fileName = "files/banks.xml";
        String schemaName = "files/banks.xsd";
        String logName = "files/log.txt";
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance((language));

        try {
            schema = factory.newSchema(new File(schemaName));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new BanksErrorHandler(logName));
            validator.validate(source);
            System.out.println(fileName + " is valid");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
