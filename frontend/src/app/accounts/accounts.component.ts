import { Component, OnInit } from '@angular/core';
import { AccountService } from '../service/account.service';
import { Account } from '../entity/account';
import { DictDataItem } from "../entity/dict-data-item";
import { ACCT_TYPE_LIST } from "../mock/mock_account_type";
import { ACCOUNTS } from '../mock/mock_account';
import { ACCT_STATUS_LIST } from '../mock/mock_account_status';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  accounts: Account[];

  acctDetail: Account;

  acctTypeList:DictDataItem[] = ACCT_TYPE_LIST;
  
  acctStatusList:DictDataItem[] = ACCT_STATUS_LIST;

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.getAllAccounts();
  }

  getAllAccounts(): void {
    this.accounts = this.accountService.getAllAccounts();
  }

  getAccountsByType(type:string):void{
    this.accounts = this.accountService.getAccountsByType(type);
  }

  selectAcct(account:Account):void{
    debugger;
    this.acctDetail=new Account();
    Object.assign(this.acctDetail,account);
  }

}
