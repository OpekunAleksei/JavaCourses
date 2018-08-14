import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Response } from '../entitys/response';

@Injectable()
export abstract class AbstractService {

  public abstract delete(id: number): Observable<Response<any>>;

  public abstract update(object: any): Observable<Response<any>>;

  public abstract create(object: any): Observable<Response<any>>;

  public abstract getAll(): Observable<Response<any[]>>;
}
