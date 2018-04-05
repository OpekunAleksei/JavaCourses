import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Service } from './service';
import { Observable } from 'rxjs/Observable';
import { HotelService } from '../hotel.service';

@Injectable()
export class ServiceService {


  constructor(private http: HttpClient, private hotelService: HotelService) { }
  getRooms(): Observable<Service[]> {
    return this.http.get<Service[]>("http://localhost:8080/web/Service",{headers:this.hotelService.getOptions()});
  }
  createService(service:Service):void {
     this.http.put("http://localhost:8080/web/Service",{service},{headers:this.hotelService.getOptions()});
  }
  changeServicePrice(service:Service): void{
     this.http.put("http://localhost:8080/web/Service",{service},{headers:this.hotelService.getOptions()});
  }

}
