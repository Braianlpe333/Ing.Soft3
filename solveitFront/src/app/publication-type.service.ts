import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class PublicationTypeService {

  constructor(private http:HttpClient){}
  
  public getType(){
   return  this.http.get('http://localhost:8088/api/v1/rest/publicationType');
  }
}
