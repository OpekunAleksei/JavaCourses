import { Component, Input, OnInit } from '@angular/core';
import * as _ from 'lodash';
import { AbstractService } from '../services/abstractService';

@Component({
  selector: 'app-table-component',
  templateUrl: './table-component.component.html',
  styleUrls: ['./table-component.component.css'],
})

export class TableComponentComponent implements OnInit {
  
  @Input() public service: AbstractService;
  @Input() public cols: any[];
  public displayDialog: boolean;
  public isCreate: boolean;
  public object: any;
  public objects: any[];
  public selectObject: any;

  constructor() {
    this.isCreate = false;
  }

  public ngOnInit() {
    this.service.getAll().subscribe((response) => {
      if (response.isSuccess) {
        this.objects = response.data;
      }
    });
  }

  showDialogToAdd() {
    this.isCreate = true;
    this.object = {};
    this.displayDialog = true;
  }

  public save() {
    this.service.create(this.object).subscribe((response) => {
      if (response.isSuccess) {
        this.objects.push(response.data);
        this.displayDialog = false;
      }
    });
  }

  update() {
    this.service.update(this.object).subscribe((response) => {
      if (response.isSuccess) {
        this.objects[this.objects.indexOf(this.selectObject)] = response.data;
        this.displayDialog = false;
      }
    });
  }

  delete() {
    this.service.delete(this.object.id).subscribe((response) => {
      if (response.isSuccess) {
        this.objects = this.objects.filter((object) => object !== this.selectObject);
        this.displayDialog = false;
      }
    });
  }

  onRowSelect(event) {
    this.isCreate = false;
    this.object = _.clone(event.data);
    this.displayDialog = true;
  }

}
