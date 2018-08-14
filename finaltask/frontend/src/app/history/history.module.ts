import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { DataListModule } from 'primeng/datalist';
import { AppRoutingModule } from '../app-routing-module';
import { HistoryService } from '../services/history.service';
import { ProductHistoryComponent } from './product-history/product-history.component';
import { RentProductComponent } from './rent-product/rent-product.component';

@NgModule({
  imports: [
    FormsModule,
    DataListModule,
    BrowserModule,
    AppRoutingModule,
  ],
  declarations: [
    ProductHistoryComponent,
    RentProductComponent,
  ],
  providers: [
    HistoryService,
  ],
})

export class HistoryModule { }
