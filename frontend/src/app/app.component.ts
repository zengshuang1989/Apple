import { Component } from '@angular/core';
import { AccountService } from './account.service';
import { Account } from './account';
import { DictDataItem } from "./dict-data-item";
import { ACCT_TYPE_LIST } from "./mock_account_type";
import { ACCOUNTS } from './mock_account';
import { ACCT_STATUS_LIST } from './mock_account_status';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';

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
    this.acctDetail = account;
  }
}
