import { Component, Input, OnInit } from '@angular/core';
import _ = require('lodash');
import { SelectItem } from 'primeng/api';
import { Product } from '../../entitys/product';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.css'],
})
export class ListViewComponent implements OnInit {
  @Input() route: string;
  @Input() objects: any[];
  @Input() filterValue: SelectItem[];
  @Input() cols: any[];
  filterObjects: any[];
  selectFilterValue: any;

  constructor() {
  }

  public ngOnInit() {
    this.filterObjects = this.objects;
  }

  filter() {
    if (this.selectFilterValue !== undefined && this.selectFilterValue.title !== 'all') {
      this.filterObjects = this.objects.filter((object) => {
        if (object.productCategory) {
          _.isEqual(this.selectFilterValue, object.productCategory);
        } else {
          _.isEqual(this.selectFilterValue, object.role);
        }
      });
    } else {
      this.filterObjects = this.objects;
    }
  }

}
