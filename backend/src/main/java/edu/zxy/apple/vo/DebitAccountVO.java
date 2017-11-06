package edu.zxy.apple.vo;

import edu.zxy.apple.entity.Account;

public class DebitAccountVO extends Account
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
}
