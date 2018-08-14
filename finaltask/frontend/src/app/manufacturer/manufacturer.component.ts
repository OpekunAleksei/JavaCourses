import { Component, OnInit } from '@angular/core';
import { ManufacturerService } from '../services/manufacturer.service';

@Component({
  selector: 'app-manufacturer',
  templateUrl: './manufacturer.component.html',
  styleUrls: ['./manufacturer.component.css'],
})

export class ManufacturerComponent implements OnInit {
  public cols: any[];

  constructor(private manufacturerService: ManufacturerService) {}

  public ngOnInit() {
    this.cols = [
      { field: 'name', header: 'Name' },
      { field: 'countryOfAssembly', header: 'Country of assembly' },
      { field: 'link', header: 'Link' },
    ];
  }

}
