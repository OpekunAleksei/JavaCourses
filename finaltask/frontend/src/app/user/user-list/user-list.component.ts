import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Role } from '../../entitys/role';
import { User } from '../../entitys/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})

export class UserListComponent implements OnInit {
  users: User[];
  roles: SelectItem[];
  cols: any[];

  constructor(private userService: UserService) {
    this.roles = new Array();
    this.cols = new Array();
  }

  public ngOnInit() {
    this.getUsers();
    this.getRoles();
    this.configurateColumns();
  }

  getUsers() {
    this.userService.getUsers().subscribe((response) => {
      if (response.isSuccess) {
        this.users = response.data;
      }
    });
  }

  getRoles() {
    const allRole = new Role('all');
    this.userService.getRoles().subscribe((response) => {
      if (response.isSuccess) {
        response.data.forEach((role) => {
          this.roles.push({ label: role.title, value: role });
        });
        this.roles.push({ label: allRole.title, value: allRole });
      }
    });
  }

  configurateColumns() {
    this.cols = [
      { field: 'nickname', header: 'Nickname' },
    ];
  }  
}
