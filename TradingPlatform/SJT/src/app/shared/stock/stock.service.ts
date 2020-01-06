import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class StockService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/stocks');
  }

  getSpecificStock(symbol : string): Observable<any> {
    return this.http.get('//localhost:8080/download/' + symbol);
  }

  deleteSpecificStock(symbol : string): Observable<any> {
    return this.http.delete('//localhost:8080/stock/' + symbol);
  }

}
