import { Manufacturer } from './manufacturer';
import { ProductCharacteristic } from './product-characteristics';
import { ProductCategory } from './productCategory';

export class Product {

  public title: string;
  public price: number;
  public id: LongRange;
  public enable: boolean;
  public manufacturer: Manufacturer;
  public productCategory: ProductCategory;
  public productCharacteristic: ProductCharacteristic[];

  constructor() {
    this.productCharacteristic = new Array();
  }
}
