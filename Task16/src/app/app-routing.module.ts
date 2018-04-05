import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { GuestComponent } from './guest/guest.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { AutorizationComponent } from './autorization/autorization.component';
import { HotelComponent } from './hotel/hotel.component';
import { RegistrationComponent } from './registration/registration.component';
import { RoomComponent } from './room/room.component';
import { ServiceComponent } from './service/service.component';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { ChangeRoomPriceComponent } from './change-room-price/change-room-price.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { ChangeServicePriceComponent } from './change-service-price/change-service-price.component';
const routes: Routes = [

  { path: '', redirectTo: '/autorization', pathMatch: 'full' },
  { path: 'changeServicePrice', component: ChangeServicePriceComponent },
  { path: 'createService', component: CreateServiceComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'changeRoomPrice', component: ChangeRoomPriceComponent },
  { path: 'createGuest', component: CreateGuestComponent },
  { path: 'hotel', component: HotelComponent },
  { path: 'room', component: RoomComponent },
  { path: 'service', component: ServiceComponent },
  { path: 'guest', component: GuestComponent },
  { path: 'signIn', component: SignInComponent },
  { path: 'autorization', component: AutorizationComponent }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
