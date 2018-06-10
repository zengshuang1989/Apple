import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgZorroAntdModule } from 'ng-zorro-antd';

import { AppComponent } from './app.component';
import { AccountService } from './service/account.service';
import { AppRoutingModule } from './/app-routing.module';
import { AccountsComponent } from './accounts/accounts.component';


@NgModule({
  declarations: [
    AppComponent,
    AccountsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgZorroAntdModule.forRoot(),
    AppRoutingModule
  ],
  providers: [AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
