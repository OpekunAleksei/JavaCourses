import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { Response } from '../entitys/response';
import { Role } from '../entitys/role';
import { User } from '../entitys/user';

@Injectable()
export class UserService {

  constructor(private cookieService: CookieService,
              private http: HttpClient) { }

  public isUserAuthenticated() {
    if (this.cookieService.get('token').length !== 0) {
      return true;
    } else {
      return false;
    }
  }

  getUserId(): number {
    return parseInt(this.cookieService.get('userId'), 10);
  }

  logOut() {
    console.log(this.cookieService.getAll());
    this.cookieService.deleteAll('/ ');
    console.log(this.cookieService.getAll());
  }

  isUserAdmin() {
    return (this.cookieService.get('roleId') === '2');
  }

  getUserWithPerson(id: number): Observable<Response<User>> {
    return this.http.get<Response<User>>(environment.userWithPersonUrl + id.toString());
  }

  getRoles(): Observable<Response<Role[]>> {
    return this.http.get<Response<Role[]>>(environment.rolesUrl);
  }

  changeUserProfile(user: User): Observable<Response<User>> {
    return this.http.post<Response<User>>(environment.changeUserProfileUrl, user);
  }

  getUsers(): Observable<Response<User[]>> {
    return this.http.get<Response<User[]>>(environment.allUsersUrl);
  }

  getUsersByRole(role: Role): Observable<Response<User[]>> {
    return this.http.post<Response<User[]>>(environment.usersByRoleUrl, role);
  }

  getDebtorUsers(): Observable<Response<User[]>> {
    return this.http.get<Response<User[]>>(environment.debtorUsers);
  }

  signIn(user: User): Observable<Response<any[]>> {
    return this.http.post<Response<any>>(environment.signInUrl, user);
  }

  signOut(): Observable<Response<any>> {
    return this.http.post<Response<any[]>>(environment.signOutUrl, this.cookieService.get('token'));
  }

  chekLogin(login: string): Observable<Response<User>> {
    return this.http.post<Response<User>>(environment.chekLoginUrl, login);
  }

  createUser(user: User): Observable<Response<User>> {
    return this.http.put<Response<User>>(environment.createUserUrl, user);
  }

   chekNick(nickName: string): Observable<Response<User>> {
    return this.http.post<Response<User>>(environment.chekNickUrl, nickName);
  }
}
