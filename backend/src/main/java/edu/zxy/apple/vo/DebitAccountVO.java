package edu.zxy.apple.vo;

import edu.zxy.apple.enums.AccountType;

public class DebitAccountVO extends AccountVO
{
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
