import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../../entitys/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css'],
})

export class SignInComponent {

  public user: User;

  constructor(private userService: UserService,
              private router: Router,
              private cookieService: CookieService) {
    this.user = new User();
  }

  public signIn(): void {
    this.userService.signIn(this.user).subscribe((response) => {
      this.cookieService.set('token', response.data[1]);
      this.cookieService.set('userId', response.data[0].id);
      this.cookieService.set('roleId', response.data[0].role.id);
      this.router.navigate(['/']);
    });
  }
}
