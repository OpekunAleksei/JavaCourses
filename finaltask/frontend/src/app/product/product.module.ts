import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { DataListModule } from 'primeng/datalist';
import { DataViewModule } from 'primeng/dataview';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule, ConfirmDialogModule } from 'primeng/primeng';
import { TableModule } from 'primeng/table';
import { AppRoutingModule } from '../app-routing-module';
import { LayoutModule } from '../layout/layout.module';
import { ProductService } from '../services/product.service';
import { ProductProfileMetaComponent } from './product-profile-meta/product-profile-meta.component';
import { ProductProfileComponent } from './product-profile/product-profile.component';
import { ProductSettingsComponent } from './product-settings/product-settings.component';
import { ProductComponent } from './product.component';

@NgModule({
  imports: [
    AppRoutingModule,
    DropdownModule,
    FormsModule,
    LayoutModule,
    ButtonModule,
    ConfirmDialogModule,
    BrowserModule,
    TableModule,
    DataViewModule,
    DialogModule,
    DataListModule,
  ],
  declarations: [
    ProductComponent,
    ProductProfileComponent,
    ProductSettingsComponent,
    ProductProfileMetaComponent,
  ],
  providers: [
    ProductService,
  ],
  exports: [
    ProductComponent,
    ProductProfileComponent,
    ProductSettingsComponent,
    ProductProfileMetaComponent,
  ],
})
export class ProductModule { }
