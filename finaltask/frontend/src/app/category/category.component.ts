import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
})

export class CategoryComponent implements OnInit {
  
  public cols: any[];

  constructor(private categoryService: CategoryService) { }

  public ngOnInit() {
    this.cols = [
      { field: 'title', header: 'Title' },
    ];
  }

}
