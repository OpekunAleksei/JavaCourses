import { Component, OnInit } from '@angular/core';
import { Guest } from './guest';
import { GuestService } from './guest.service';

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {
  guests: Guest[];
  constructor(private guestService: GuestService) {
    this.guests = new Array<Guest>();
  }
  ngOnInit() {
    this.guestService.getGuests().subscribe(guests => this.guests = guests);
  }

  deleteGuest(guest: Guest) {
    this.guests = this.guests.filter(h => h !== guest);
    this.guestService.deleteGuest(guest);
  }
}