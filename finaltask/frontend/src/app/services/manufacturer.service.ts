import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { Manufacturer } from '../entitys/manufacturer';
import { Response } from '../entitys/response';
import { AbstractService } from './abstractService';

@Injectable()
export class ManufacturerService implements AbstractService {

  constructor(private http: HttpClient) { }

  public create(manufacturer: Manufacturer): Observable<Response<Manufacturer>> {
    return this.http.put<Response<Manufacturer>>(environment.createManufacturerUrl, manufacturer);
  }

  public getAll(): Observable<Response<Manufacturer[]>> {
    return this.http.get<Response<Manufacturer[]>>(environment.allManufacturersUrl);
  }

  public delete(id: number): Observable<Response<Manufacturer>> {
    return this.http.delete<Response<Manufacturer>>(environment.deleteManufacturerUrl + id.toString());
  }
  
  public update(manufacturer: Manufacturer): Observable<Response<Manufacturer>> {
    return this.http.post<Response<Manufacturer>>(environment.updateManufacturerUrl, manufacturer);
  }
}
