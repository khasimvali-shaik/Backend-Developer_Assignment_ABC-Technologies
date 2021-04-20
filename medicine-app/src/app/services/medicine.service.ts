import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor( private http: HttpClient) { }

  displayMedicine():Observable<any>{
    return this.http.get('http://localhost:8080/display');
  }

  orderMedicine(data):Observable<any>{
    return this.http.post('http://localhost:8080/placeorder',data,{responseType: "text"});
    
  }
}

