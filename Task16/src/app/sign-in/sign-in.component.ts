import { Component } from '@angular/core';

import { AutorizationService } from '../autorization.service';
import { User } from '../registration/user';
import { HotelService } from '../hotel.service';
import { Token } from './token';
import { Router,
  NavigationExtras } from '@angular/router';
@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  constructor(private server: AutorizationService, private hotelService: HotelService,private router:Router) {
  }


  signIn(login: HTMLInputElement, password: HTMLInputElement) {
    var user = new User(login.value, password.value);
    this.server.signIn(user).subscribe(token => {
      this.hotelService.setToken(token);
      if(token!=null){
        let redirect = '/hotel';
        let navigationExtras: NavigationExtras = {
          queryParamsHandling: 'preserve',
          preserveFragment: true
        };
        this.router.navigate([redirect], navigationExtras);
      }
      
    });

  }
}
