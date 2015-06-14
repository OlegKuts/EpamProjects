package validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * Created by oleg on 12.06.15.
 */
public class BanksErrorHandler implements ErrorHandler {
    private Logger logger = Logger.getLogger("validator");

    public BanksErrorHandler(String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.warn(getLineAddress(exception) + "-" + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.error(getLineAddress(exception) + "-" + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.fatal(getLineAddress(exception) + "-" + exception.getMessage());
    }

    private String getLineAddress(SAXParseException exception) {
        return exception.getLineNumber() + ":" + exception.getColumnNumber();
    }
}
