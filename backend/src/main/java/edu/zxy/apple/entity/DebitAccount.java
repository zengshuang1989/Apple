package edu.zxy.apple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zxy.apple.enums.AccountType;

@Entity
@Table(name = "debit_account")
public class DebitAccount extends Account
{

    @Column(name = "over_draftFee")
    private double overdraftFee;

    public double getOverdraftFee()
    {
        return overdraftFee;
    }

    public void setOverdraftFee(double overdraftFee)
    {
        this.overdraftFee = overdraftFee;
    }
    
    public AccountType getType()
    {
        return AccountType.DEBT;
    }

}
