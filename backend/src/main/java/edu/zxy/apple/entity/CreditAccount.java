package edu.zxy.apple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_account")
public class CreditAccount extends Account
{

    @Column(name = "credit_limit")
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
