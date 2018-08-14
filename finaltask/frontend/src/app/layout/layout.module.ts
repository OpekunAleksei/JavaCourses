import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { DataViewModule } from 'primeng/dataview';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule, ConfirmDialogModule, DataListModule, DialogModule, TabMenuModule } from 'primeng/primeng';
import { TableModule } from 'primeng/table';
import { AppRoutingModule } from '../app-routing-module';
import { AuthorizationModule } from '../authorization/authorization.module';
import { HeaderComponent } from './header/header.component';
import { ListViewComponent } from './list-view/list-view.component';

@NgModule({
  imports: [
      AppRoutingModule,
      DropdownModule,
      FormsModule,
      CommonModule,
      AuthorizationModule,
      AppRoutingModule,
      DropdownModule,
      FormsModule,
      ButtonModule,
      ConfirmDialogModule,
      BrowserModule,
      TableModule,
      DataViewModule,
      TabMenuModule,
      DialogModule,
      DataListModule,
    ],
  declarations: [
    HeaderComponent,
    ListViewComponent,
    ],
  exports: [
    HeaderComponent,
    ListViewComponent,
    ],
})
export class LayoutModule { }
