package parsers.builder;

import entity.Bank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by oleg on 12.06.15.
 */
public abstract class AbstractBanksBuilder {
    protected Set<Bank> banks;

    public AbstractBanksBuilder() {
        banks = new HashSet<Bank>();
    }

    public AbstractBanksBuilder(Set<Bank> banks) {
        this.banks = banks;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    abstract public void buildBanksSet(String fileName);
}
