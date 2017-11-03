package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.Account;

public interface AccountDao {
	public List<Account> getAll();
    public void add(Account account);

}
