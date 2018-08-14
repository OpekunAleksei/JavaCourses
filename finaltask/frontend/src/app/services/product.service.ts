import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { Manufacturer } from '../entitys/manufacturer';
import { Product } from '../entitys/product';
import { ProductCategory } from '../entitys/productCategory';
import { Response } from '../entitys/response';

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) { }

  public create(product: Product): Observable<Response<Product>> {
    return this.http.put<Response<Product>>(environment.createProductUrl, product);
  }

  public getAll(): Observable<Response<Product[]>> {
    return this.http.get<Response<Product[]>>(environment.allProductsUrl);
  }

  public delete(id: number): Observable<Response<Product>> {
    return this.http.delete<Response<Product>>(environment.deleteProductUrl + id.toString());
  }

  public update(product: Product): Observable<Response<Product>> {
    return this.http.post<Response<Product>>(environment.updateProductUrl, product);
  }

  public getManufacturer(product: Product): Observable<Response<Manufacturer>> {
    return this.http.post<Response<Manufacturer>>(environment.productManufacturerUrl, product);
  }

  public getProductsByCategory(category: ProductCategory): Observable<Response<Product[]>> {
    return this.http.post<Response<Product[]>>(environment.productsByCategoryUrl, category);
  }

  public checkProductTitle(title: string): Observable<Response<any>> {
    return this.http.post<Response<any>>(environment.checkProductTitle, title);
  }

  public getProductWithCharacteristics(id: number) {
    return this.http.get<Response<any>>(environment.getProductWithCharacteristics + id.toString());
  }

  public getGeoLocation(address: string): Observable<any> {
    console.log('Getting address: ', address);
    return Observable.create((observer) => {
      observer.next(address);
      observer.complete();
    });
  }
}
