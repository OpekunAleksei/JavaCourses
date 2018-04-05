import { Component, OnInit, Input } from '@angular/core';
import { GuestService } from '../guest/guest.service';
import { Guest } from '../guest/guest';
import { GuestComponent } from '../guest/guest.component';


@Component({
  selector: 'app-create-guest',
  templateUrl: './create-guest.component.html',
  styleUrls: ['./create-guest.component.css']
})
export class CreateGuestComponent implements OnInit {


  constructor(private guestService: GuestService) { }

  ngOnInit() {
  }
  createGuest(name: HTMLInputElement, arrivalDate: HTMLInputElement, departureDate: HTMLInputElement) {


    var guest = new Guest(name.value, new Date(arrivalDate.value).toString().substr(0, 10), new Date(departureDate.value).toString().substr(0, 10));
    this.guestService.createGuest(guest);

  }
}
