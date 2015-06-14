package parsers.builder;

/**
 * Created by oleg on 12.06.15.
 */
public enum BankEnum {
    BANKS("banks"),
    BANK("bank"),
    TYPE("type"),
    ACCOUNTID("accountId"),
    DEPOSIT("deposit"),
    NAME("name"),
    COUNTRY("country"),
    DEPOSITOR("depositor"),
    AMOUNT("amount"),
    PROFITABILITY("profitability"),
    CONSTRAINTS("constraints");
    private String value;

    BankEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
