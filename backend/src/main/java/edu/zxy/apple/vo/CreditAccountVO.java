package edu.zxy.apple.vo;

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
}
