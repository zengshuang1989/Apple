import { Component } from '@angular/core';
import { AccountService } from './account.service';
import { Account } from './account';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';

  accounts: Account[];

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.getAllAccounts();
  }

  getAllAccounts(): void {
    this.accounts = this.accountService.getAllAccounts();
  }
}
