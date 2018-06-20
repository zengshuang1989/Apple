import { Component } from '@angular/core';
import { AccountService } from './service/account.service';
import { Account } from './entity/account';
import { DictDataItem } from "./entity/dict-data-item";
import { ACCT_TYPE_LIST } from "./mock/mock_account_type";
import { ACCOUNTS } from './mock/mock_account';
import { ACCT_STATUS_LIST } from './mock/mock_account_status';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

}
