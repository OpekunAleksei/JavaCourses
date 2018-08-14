import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/urls';
import { Characteristic } from '../entitys/characteristic';
import { Response } from '../entitys/response';
import { AbstractService } from './abstractService';

@Injectable()
export class CharacteristicService implements AbstractService {

  constructor(private http: HttpClient) { }

  public create(characteristic: Characteristic): Observable<Response<Characteristic>> {
    return this.http.put<Response<Characteristic>>(environment.createCharacteristicUrl, characteristic);
  }

  public getAll(): Observable<Response<Characteristic[]>> {
    return this.http.get<Response<Characteristic[]>>(environment.allCharacteristicsUrl);
  }

  public delete(id: number): Observable<Response<Characteristic>> {
    return this.http.delete<Response<Characteristic>>(environment.deleteCharacteristicUrl + id.toString());
  }

  public update(characteristic: Characteristic): Observable<Response<Characteristic>> {
    return this.http.post<Response<Characteristic>>(environment.updateCharacteristicUrl, characteristic);
  }
}
