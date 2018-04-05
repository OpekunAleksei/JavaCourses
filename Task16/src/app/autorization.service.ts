import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './registration/user';
import { Observable } from 'rxjs/Observable';
import { Token } from './sign-in/token';

@Injectable()
export class AutorizationService {

  constructor(private http: HttpClient) { }
  signIn(user: User):Observable<Token> {

    return this.http.post<Token>("http://localhost:8080/web/LogIn", {user});
  }
  registration(user: User) :void{

     this.http.post("http://localhost:8080/web/Registration", {user});
  }
}
