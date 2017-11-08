package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.DebitAccount;

public interface DebitAccountDao
{
    public List<DebitAccount> getAll();

    public void add(DebitAccount account);
}
