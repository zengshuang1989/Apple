package edu.zxy.apple.vo;

import edu.zxy.apple.enums.AccountType;

public class CreditAccountVO extends AccountVO
{
    private double creditLimit;
    

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit)
    {
        this.creditLimit = creditLimit;
    }
    
    public AccountType getType()
    {
        return AccountType.CREDIT_CARD;
    }
    
    public void setType(AccountType accountType)
    {
        super.setType(AccountType.CREDIT_CARD);
    }
}
