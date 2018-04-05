import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Room } from './room';
import { HotelService } from '../hotel.service';

@Injectable()
export class RoomService {

  constructor(private http: HttpClient, private hotelService: HotelService) { }
  getRooms(): Observable<Room[]> {

    return this.http.get<Room[]>("http://localhost:8080/web/Room", { headers: this.hotelService.getOptions() });
  }
  changeRoomPrice(room: Room) :void{
   this.http.post("http://localhost:8080/web/Room", { room }, { headers: this.hotelService.getOptions() });
  }
}
