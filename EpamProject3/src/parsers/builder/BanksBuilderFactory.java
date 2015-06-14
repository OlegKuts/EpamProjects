package parsers.builder;

import parsers.dom.BanksDOMBuilder;
import parsers.sax.BanksSAXBuilder;
import parsers.stax.BanksStAXBuilder;

/**
 * Created by oleg on 12.06.15.
 */
public class BanksBuilderFactory {
    private enum ParserType {
        SAX, DOM, STAX
    }

    public AbstractBanksBuilder createBankBuilder(String typeOfParser) {
        ParserType type = ParserType.valueOf(typeOfParser.toUpperCase());
        switch (type) {
            case SAX:
                return new BanksSAXBuilder();
            case DOM:
                return new BanksDOMBuilder();
            case STAX:
                return new BanksStAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
