package edu.zxy.apple.vo;

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
}
