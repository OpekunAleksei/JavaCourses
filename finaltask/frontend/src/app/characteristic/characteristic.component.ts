import { Component, OnInit } from '@angular/core';
import { CharacteristicService } from '../services/characteristic.service';

@Component({
  selector: 'app-characteristic',
  templateUrl: './characteristic.component.html',
  styleUrls: ['./characteristic.component.css'],
})

export class CharacteristicComponent implements OnInit {

  public cols: any[];

  constructor(private characteristicService: CharacteristicService) { }

  public ngOnInit() {
    this.cols = [
      { field: 'name', header: 'Name' },
    ];
  }
}
