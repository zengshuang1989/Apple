package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.CreditAccount;

public interface CreditAccountDao
{
    public List<CreditAccount> getAll();

    public void add(CreditAccount account);
}
