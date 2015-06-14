package parsers;

import parsers.builder.AbstractBanksBuilder;
import parsers.builder.BanksBuilderFactory;

/**
 * Created by oleg on 12.06.15.
 */
public class Main {
    public static void main(String[] args) {
        BanksBuilderFactory factory = new BanksBuilderFactory();
        AbstractBanksBuilder builder = factory.createBankBuilder("dom");
        builder.buildBanksSet("files/banks.xml");
        System.out.println(builder.getBanks());
    }
}
