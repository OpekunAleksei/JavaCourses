import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MomentModule } from 'angular2-moment';
import { CookieService } from 'ngx-cookie-service';
import { DataListModule } from 'primeng/datalist';
import { DataViewModule } from 'primeng/dataview';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule, ConfirmDialogModule, PanelModule } from 'primeng/primeng';
import { TableModule } from 'primeng/table';
import { TabMenuModule } from 'primeng/tabmenu';
import { AppRoutingModule } from './app-routing-module';
import { AppComponent } from './app.component';
import { AuthorizationModule } from './authorization/authorization.module';
import { CategoryComponent } from './category/category.component';
import { CharacteristicComponent } from './characteristic/characteristic.component';
import { EquipmentRentalInterceptor } from './interseptors/equipmentrental-interseptor';
import { LayoutModule } from './layout/layout.module';
import { ManufacturerComponent } from './manufacturer/manufacturer.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProductModule } from './product/product.module';
import { CategoryService } from './services/category.service';
import { CharacteristicService } from './services/characteristic.service';
import { ManufacturerService } from './services/manufacturer.service';
import { TableComponentComponent } from './table-component/table-component.component';
import { UserModule } from './user/user.module';

@NgModule({
  declarations: [
    AppComponent,
    ManufacturerComponent,
    CharacteristicComponent,
    CategoryComponent,
    CharacteristicComponent,
    NotFoundComponent,
    ManufacturerComponent,
    TableComponentComponent,
    CategoryComponent,
  ],
  imports: [
    LayoutModule,
    AppRoutingModule,
    TabMenuModule,
    DataViewModule,
    ButtonModule,
    PanelModule,
    ConfirmDialogModule,
    TableModule,
    DropdownModule,
    DialogModule,
    MomentModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ProductModule,
    UserModule,
    DataListModule,
    AuthorizationModule,
  ],
  providers: [
    CookieService,
    ManufacturerService,
    CharacteristicService,
    CategoryService,
    { provide: HTTP_INTERCEPTORS, useClass: EquipmentRentalInterceptor, multi: true },
  ],
  bootstrap: [
    AppComponent,
  ],
  exports: [
    AppRoutingModule,
  ],
})

export class AppModule { }
