import { Component, OnInit, Input } from '@angular/core';
import { RoomService } from './room.service';
import { Room } from './room';
import { ChangeRoomPriceComponent } from '../change-room-price/change-room-price.component';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  rooms: Room[];

  constructor(private roomService: RoomService,private hotelService:HotelService) {
    this.rooms = new Array<Room>();
  }

  ngOnInit() {
    this.roomService.getRooms().subscribe(rooms => this.rooms = rooms);
  }
  update(room: Room) {
    this.hotelService.set(room);
  }
}
