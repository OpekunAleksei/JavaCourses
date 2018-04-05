import { Injectable } from '@angular/core';
import { Guest } from './guest';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HotelService } from '../hotel.service';

@Injectable()
export class GuestService {

  constructor(private http: HttpClient, private hotelService: HotelService) { }
  getGuests(): Observable<Guest[]> {
    return this.http.get<Guest[]>("http://localhost:8080/web/Guest",{headers:this.hotelService.getOptions()});
  }
  deleteGuest(guest: Guest) :void{
   this.http.post("http://localhost:8080/web/DeleteGuest", { guest },{headers:this.hotelService.getOptions()});
  }
  createGuest(guest:Guest) :void{
  this.http.put("http://localhost:8080/web/Guest", { guest},{headers:this.hotelService.getOptions()});
  }
}
