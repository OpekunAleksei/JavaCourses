import { Component, OnInit } from '@angular/core';
import { ServiceService } from './service.service';
import { Service } from './service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  private services: Service[];
  constructor(private serviceService:ServiceService,private hotelService:HotelService) { }

  ngOnInit() {
    this.serviceService.getRooms().subscribe(rooms => this.services = rooms);
  }
    update(service: Service) {
    this.hotelService.setService(service);
  }
}
