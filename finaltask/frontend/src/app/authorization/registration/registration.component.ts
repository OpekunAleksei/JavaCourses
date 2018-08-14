import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../entitys/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})

export class RegistrationComponent implements OnInit {
  @Input() user: User;
  @Output() updateComplete = new EventEmitter();
  currentUser: User;
  isUserUpdate: boolean;
  userform: FormGroup;
  loiginIdentical: boolean;
  nickNameIdentical: boolean;
  constructor(private userService: UserService,
              private router: Router,
              private fb: FormBuilder) {
    this.currentUser = new User();
    this.loiginIdentical = false;
    this.nickNameIdentical = false;
  }

  ngOnInit(): void {
    this.userFormConfiguration();
    this.conifgureUserForm();

  }

  conifgureUserForm() {
    if (this.user === undefined) {
      this.isUserUpdate = false;
    } else {
      this.isUserUpdate = true;
      this.currentUser.clone(this.user);
      this.userform.get('passwords').get('confirm').clearValidators();
      this.userform.get('passwords').get('pwd').clearValidators();
      this.userform.get('nickname').disable();
      this.userform.get('login').disable();
    }
  }

  userFormConfiguration() {
    this.userform = new FormGroup({
      firstname: new FormControl('', Validators.required),
      secondname: new FormControl('', Validators.required),
      nickname: new FormControl('', Validators.required),
      phoneNumber: new FormControl('', Validators.required),
      email: new FormControl('', Validators.compose(
        [
          Validators.required,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$'),
        ])),
      passwords: this.fb.group({
        pwd: ['', Validators.required],
        confirm: ['', Validators.required],
      }, { validator: this.passwordsAreEqual() }),
      login: new FormControl('', Validators.required),
    });
  }

  public createUser(user: User) {
    this.userService.createUser(user).subscribe((response) => {
      if (response.isSuccess) {
        this.router.navigate(['/signIn']);
      } else {
      }
    });
  }

  private passwordsAreEqual(): ValidatorFn {
    return (group: FormGroup): { [key: string]: any } => {
      if (!(group.dirty || group.touched) || group.get('pwd').value === group.get('confirm').value) {
        return null;
      }
      return {
        custom: 'Passwords are not equal',
      };
    };
  }

  updateUser(user: User) {
    this.userService.changeUserProfile(user).subscribe((response) => {
      if (response.isSuccess) {
        this.updateComplete.emit(response.data);
      }
    });

  }

  passwordValidate(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      if ((control.value === undefined || !control.dirty || !control.touched)) {
        return null;
      } else {
        return {
          custom: 'Wrong password',
        };
      }
    };
  }

  checkNickIdentical() {
    this.userService.chekNick(this.currentUser.nickname).subscribe((isIdentical) => {
      this.nickNameIdentical = !isIdentical.isSuccess;

    });
  }

  checkLoginIdentical() {
    this.userService.chekLogin(this.currentUser.login).subscribe((isIdentical) => {
      this.loiginIdentical = !isIdentical.isSuccess;
    });
  }

  onSubmit() {
    this.isUserUpdate ? this.updateUser(this.currentUser) : this.createUser(this.currentUser);
  }

  back() {
    this.updateComplete.emit(this.user);
  }
}
