import { Component, OnInit, Input } from '@angular/core';
import { Room } from '../room/room';
import { HotelService } from '../hotel.service';
import { RoomService } from '../room/room.service';

@Component({
  selector: 'app-change-room-price',
  templateUrl: './change-room-price.component.html',
  styleUrls: ['./change-room-price.component.css']
})
export class ChangeRoomPriceComponent implements OnInit {

 a:any;
  room:Room;
  constructor(private hotelService:HotelService,private roomService:RoomService) {
   
   }

  ngOnInit() {

  }
changePrice(price: HTMLInputElement){
var room =this.hotelService.get();
room.price=Number(price.value);
this.roomService.changeRoomPrice(room);
  }
}
