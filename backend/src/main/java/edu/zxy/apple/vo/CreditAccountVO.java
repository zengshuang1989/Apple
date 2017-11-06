package edu.zxy.apple.vo;

import edu.zxy.apple.entity.Account;

public class CreditAccountVO extends Account
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
}
