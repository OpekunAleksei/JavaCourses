import { Component, OnInit } from '@angular/core';
import { Service } from '../service/service';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {

  constructor(private serviceService: ServiceService) { }

  ngOnInit() {
  }
  createService(category: HTMLInputElement, price: HTMLInputElement) {
    var service = new Service(Number(price.value), category.value);
    this.serviceService.createService(service);

  }
}
