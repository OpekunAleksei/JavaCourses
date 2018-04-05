import { Injectable } from '@angular/core';
import { Room } from './room/room';
import { Service } from './service/service';
import { HttpHeaders } from '@angular/common/http';
import { Token } from './sign-in/token';

@Injectable()
export class HotelService {
  private room: Room;
  private service: Service;
  private token: Token;
  private headers: HttpHeaders;

  constructor(
  ) {
    this.room = new Room(null, null, null, null, null, null);
    this.service = new Service(null, null);
    this.token;
  }
  getOptions() {
    return this.headers = new HttpHeaders().set('Authorization', this.token.Authorization);
  }
  set(room: Room) {
    this.room = room;
  }
  get() {
    return this.room;
  }
  setService(service: Service) {
    this.service = service;
  }
  getService() {
    return this.service;
  }
  setToken(token: Token) {
    this.token = token;
  }
  getToken() {
    return this.token;
  }


}
