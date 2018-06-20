import { Injectable } from '@angular/core';
import { Account } from '../entity/account';
import { ACCOUNTS } from '../mock/mock_account';

@Injectable()
export class AccountService {

  accounts: Account[];

  constructor() { }

  getAllAccounts():Account[]{
    this.accounts = ACCOUNTS
    return this.accounts;
  }

  getAccountsByType(type:string):Account[]{
    this.accounts = [];
    for (var i = 0; i < ACCOUNTS.length; i++)
    {
      if(type == ACCOUNTS[i].type)
      {
        this.accounts.push(ACCOUNTS[i])
      }
    }
    return this.accounts;
  }

}
