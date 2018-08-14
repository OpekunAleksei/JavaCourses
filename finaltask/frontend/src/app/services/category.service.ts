import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { ProductCategory } from '../entitys/productCategory';
import { Response } from '../entitys/response';
import { AbstractService } from './abstractService';

@Injectable()
export class CategoryService implements AbstractService {

  constructor(private http: HttpClient) { }

  public create(category: ProductCategory): Observable<Response<ProductCategory>> {
    return this.http.put<Response<ProductCategory>>(environment.createProductCategoryUrl, category);
  }

  public getAll(): Observable<Response<ProductCategory[]>> {
    return this.http.get<Response<ProductCategory[]>>(environment.allProductCategorysUrl);
  }

  public delete(id: number): Observable<Response<ProductCategory>> {
    return this.http.delete<Response<ProductCategory>>(environment.deleteProductCategoryUrl + id.toString());
  }

  public update(category: ProductCategory): Observable<Response<ProductCategory>> {
    return this.http.post<Response<ProductCategory>>(environment.updateProductCategoryUrl, category);
  }
}
