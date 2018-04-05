import { Component, OnInit } from '@angular/core';
import { Service } from '../service/service';
import { HotelService } from '../hotel.service';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-change-service-price',
  templateUrl: './change-service-price.component.html',
  styleUrls: ['./change-service-price.component.css']
})
export class ChangeServicePriceComponent implements OnInit {

 a:any;
  service:Service;
  constructor(private hotelService:HotelService,private serviceService:ServiceService) {
   
   }
  ngOnInit() {
  }
  changePrice(price: HTMLInputElement){
    var service =this.hotelService.getService();
    service.price=Number(price.value);
    this.serviceService.changeServicePrice(service);
      }
}
