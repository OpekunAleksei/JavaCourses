import { Component } from '@angular/core';
import { User } from './user';
import { AutorizationService } from '../autorization.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  constructor(private server: AutorizationService) { }


  registration(login: HTMLInputElement, password: HTMLInputElement) {
   var user= new User(login.value,password.value);
    this.server.registration(user);
  }
}
