import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { GuestComponent } from './guest/guest.component';
import { RoomComponent } from './room/room.component';
import { ServiceComponent } from './service/service.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HotelComponent } from './hotel/hotel.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { RegistrationComponent } from './registration/registration.component';
import { AutorizationComponent } from './autorization/autorization.component';
import { GuestService } from './guest/guest.service';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { AutorizationService } from './autorization.service';
import { RoomService } from './room/room.service';
import { ChangeRoomPriceComponent } from './change-room-price/change-room-price.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { ServiceService } from './service/service.service';
import { ChangeServicePriceComponent } from './change-service-price/change-service-price.component';
import { HotelService } from './hotel.service';



@NgModule({
  declarations: [
    AppComponent,
    GuestComponent, ChangeRoomPriceComponent, RoomComponent, ServiceComponent, HotelComponent, SignInComponent, RegistrationComponent, AutorizationComponent, CreateGuestComponent, CreateServiceComponent, ChangeServicePriceComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, AppRoutingModule
  ],
  providers: [GuestService, AutorizationService, RoomService, ServiceService, HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
