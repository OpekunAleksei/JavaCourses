import { Component, Input, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Product } from '../entitys/product';
import { ProductCategory } from '../entitys/productCategory';
import { CategoryService } from '../services/category.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {

  products: Product[];
  categorys: SelectItem[];
  cols: any[];

  constructor(private productService: ProductService,
              private categoryService: CategoryService) {
    this.categorys = new Array();
  }

  ngOnInit() {
    this.configurateColumns();
    this.getProducts();
    this.getCategorys();
  }

  getProducts() {
    this.productService.getAll().subscribe((products) => {
      if (products.isSuccess) {
        this.products = products.data;
      }
    });
  }

  getCategorys() {
    const allCategory = new ProductCategory('all');
    this.categoryService.getAll().subscribe((categorys) => {
      if (categorys.isSuccess) {
        categorys.data.forEach((category) => {
          this.categorys.push({ label: category.title, value: category });
        });
        this.categorys.push({ label: allCategory.title, value: allCategory });
      }
    });
  }

  configurateColumns() {
    this.cols = [
      { field: 'title', header: 'Title' },
      { field: 'price', header: 'Price' },
    ];
  }
}
