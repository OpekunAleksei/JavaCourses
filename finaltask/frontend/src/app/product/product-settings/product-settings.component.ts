import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import _ = require('lodash');
import { SelectItem } from 'primeng/api';
import { Product } from '../../entitys/product';
import { ProductCharacteristic } from '../../entitys/product-characteristics';
import { CategoryService } from '../../services/category.service';
import { CharacteristicService } from '../../services/characteristic.service';
import { ManufacturerService } from '../../services/manufacturer.service';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-settings',
  templateUrl: './product-settings.component.html',
  styleUrls: ['./product-settings.component.css'],
})

export class ProductSettingsComponent implements OnInit {
  @Input() isProductCreate: boolean;
  @Input() product: Product;
  @Output() createProduct: EventEmitter<Product>;
  public displayDialog: boolean;
  public isCreate: boolean;
  manufacturers: SelectItem[];
  categorys: SelectItem[];
  characteristics: SelectItem[];
  productCharacterstic: ProductCharacteristic;
  selectProductCharacteristic: ProductCharacteristic;

  constructor(private manufacturerService: ManufacturerService,
              private categoryService: CategoryService,
              private characteristicService: CharacteristicService,
              private productService: ProductService) {
    this.createProduct = new EventEmitter();
    this.manufacturers = new Array();
    this.characteristics = new Array();
    this.categorys = new Array();
    this.isCreate = false;
  }

  ngOnInit() {
    if (this.isProductCreate) {
      this.product = new Product();
      this.getManufacturers();
      this.getCategorys();
    }
    this.getCharacteristics();
  }

  getManufacturers() {
    this.manufacturerService.getAll().subscribe((manufacturers) => {
      if (manufacturers.isSuccess) {
        manufacturers.data.forEach((manufacturer) => {
          this.manufacturers.push({ label: manufacturer.name, title: manufacturer.countryOfAssembly, value: manufacturer });
        });
      }
    });
  }

  getCategorys() {
    this.categoryService.getAll().subscribe((categorys) => {
      if (categorys.isSuccess) {
        categorys.data.forEach((category) => {
          this.categorys.push({ label: category.title, value: category });
        });
      }
    });
  }

  getCharacteristics() {
    this.characteristicService.getAll().subscribe((characteristics) => {
      if (characteristics.isSuccess) {
        characteristics.data.forEach((characteristic) => {
          this.characteristics.push({ label: characteristic.name, value: characteristic });
        });
      }
    });
  }

  showDialogToAdd() {
    this.isCreate = true;
    this.productCharacterstic = {} as ProductCharacteristic;
    this.displayDialog = true;
  }

  public saveCharacteristic() {
    this.product.productCharacteristic.push(this.productCharacterstic);
    this.displayDialog = false;
  }

  updateCharacteristic() {
    this.product.productCharacteristic[this.product.productCharacteristic.
      indexOf(this.selectProductCharacteristic)] = this.productCharacterstic;
    this.displayDialog = false;
  }

  deleteCharacteristic() {
    this.product.productCharacteristic = this.product.productCharacteristic.
      filter((object) => object !== this.selectProductCharacteristic);
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.isCreate = false;
    this.productCharacterstic = _.clone(event.data);
    this.displayDialog = true;
  }

  saveProduct() {
    this.productService.create(this.product).subscribe((product) => {
      if (product.isSuccess) {
        this.createProduct.emit(this.product);
      }
    });
  }

  updateProduct() {
    this.productService.update(this.product).subscribe((product) => {
      if (product.isSuccess) {
        this.createProduct.emit(this.product);
      }
    });
  }
}
