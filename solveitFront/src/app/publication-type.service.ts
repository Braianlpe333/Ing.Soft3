import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class PublicationTypeService {

  constructor(private http:HttpClient){}
  
  public getType(){
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxN…2OTV9.-f08BujjRsBrEYMKPYbGHZIX3yt3E8N6lpNbvpVtv8U'
    const headers = { 'Authorization': 'Bearer '+token}
   return  this.http.get<any>('api/v1/rest/publicationType',{headers});
  }
}
