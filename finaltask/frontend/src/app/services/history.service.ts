import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { Product } from '../entitys/product';
import { Response } from '../entitys/response';
import { User } from '../entitys/user';

@Injectable()
export class HistoryService {

  constructor(private http: HttpClient) { }

  public rent(history: History, product: Product, user: User): Observable<Response<History>> {
    return this.http.put<Response<History>>(environment.rentProductUrl, { history, product, user });
  }

  public returnProduct(product: Product): Observable<Response<number>> {
    return this.http.post<Response<number>>(environment.returnProductUrl, product);
  }

  public getReturnDateOfProduct(product: Product): Observable<Response<Date>> {
    return this.http.post<Response<Date>>(environment.returnDateOfProductUrl, product);
  }
  
  public getUserProducts(user: User): Observable<Response<Product[]>> {
    return this.http.post<Response<Product[]>>(environment.userProductsUrl, user);
  }

  public getProductHistorys(product: Product): Observable<Response<History[]>> {
    return this.http.post<Response<History[]>>(environment.productHistorysUrl, product);
  }
}
