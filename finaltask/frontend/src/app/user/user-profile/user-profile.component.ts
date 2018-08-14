import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../entitys/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})

export class UserProfileComponent implements OnInit {
  public user: User;
  public isUserUpdate: boolean;

  constructor(private route: ActivatedRoute,
              private userService: UserService) {
    this.isUserUpdate = false;
  }

  public ngOnInit() {
    this.route.params.subscribe(
      (params) => {
        this.userService.getUserWithPerson(+params.id).subscribe((response) => {
          this.user = response.data;
        });
      },
    );
  }

  updateUser(user: User) {
    this.user = user;
    this.isUserUpdate = false;
  }
}
