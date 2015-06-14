package entity;


import javax.xml.datatype.Duration;

/**
 * Created by oleg on 12.06.15.
 */
public class Bank {
    private String name;
    private String country;
    private Deposit deposit = new Deposit();

    public Bank() {
    }

    public Bank(String name, String country, Deposit deposit) {
        this.name = name;
        this.country = country;
        this.deposit = deposit;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "\nname: " + name + "\ncountry: " + country + deposit.toString();
    }

    public static class Deposit {
        private String depositor;
        private double amount;
        private double profitability;
        private Duration constraints;
        private String type;
        private String accountId;

        public Deposit() {
        }

        public Deposit(String depositor, double amount, double profitability, Duration constraints, String type, String accountId) {
            this.depositor = depositor;
            this.amount = amount;
            this.profitability = profitability;
            this.constraints = constraints;
            this.type = type;
            this.accountId = accountId;
        }

        public String getDepositor() {
            return depositor;
        }

        public void setDepositor(String depositor) {
            this.depositor = depositor;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getProfitability() {
            return profitability;
        }

        public void setProfitability(double profitability) {
            this.profitability = profitability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Duration getConstraints() {
            return constraints;
        }

        public void setConstraints(Duration constraints) {
            this.constraints = constraints;
        }

        @Override
        public String toString() {
            return "\nDeposit: " + "\n\tdepositor: " + depositor +
                    "\n\taccountId: " + accountId +
                    "\n\tamount: " + amount +
                    "\n\tprofitability: " + profitability + "%" +
                    "\n\tconstraints: " + constraints.getYears() + " year(s) " + constraints.getMonths() + " month" +
                    "\n\ttype: " + type + '\n';
        }
    }
}
