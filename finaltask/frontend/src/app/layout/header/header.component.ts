import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})

export class HeaderComponent implements OnInit {
  todayDate: number;
  authUserItems: MenuItem[];
  notAuthUserItems: MenuItem[];
  adminItems: MenuItem[];

  constructor(private userService: UserService,
              private router: Router) {
    this.todayDate = Date.now();
  }

  ngOnInit() {
    this.authUserItems = [
      { label: 'Products', routerLink: '/products' },
      { label: 'User profile', command: (event) => { this.router.navigate(['userProfile', this.userService.getUserId()]); } },
      { label: 'Sign out', command: (event) => { this.logOut(); } },
    ];
    this.notAuthUserItems = [
      { label: 'Products', routerLink: '/products' },
      { label: 'Sign in', routerLink: '/signIn' },
      { label: 'Sign up', routerLink: '/signUp' },
    ];
    this.adminItems = [
      { label: 'Products', routerLink: '/products' },
      { label: 'Users', routerLink: '/users' },
      { label: 'User profile', command: (event) => { this.router.navigate(['userProfile', this.userService.getUserId()]); } },
      { label: 'Characteristics', routerLink: '/characteristics' },
      { label: 'Categorys', routerLink: '/categorys' },
      { label: 'Manufacturers', routerLink: '/manufacturers' },
      { label: 'Sign out', command: (event) => { this.logOut(); } },
    ];
  }

  public logOut() {
    this.userService.signOut().subscribe((response) => {
      if (response.isSuccess) {
        this.userService.logOut();
        this.router.navigate(['/']);
      }
    });
  }
}
