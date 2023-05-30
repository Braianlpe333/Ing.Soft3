import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Component({
  selector: 'app-create-publication',
  templateUrl: './create-publication.component.html',
  styleUrls: ['./create-publication.component.css']
})
export class CreatePublicationComponent implements OnInit {
  type: any;

  submit(publication: any){
    console.log("Form submitted",publication.form.value);


    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNjg0OTc5NDgxLCJleHAiOjE2ODUwMTU0ODF9.6YTeMKYU0o2ggcjlrrW_7ofrT9bZRiRRDU9vVNm4aTA'
    const headers = { 'Authorization': 'Bearer '+token}
    var body = {publicationTitle:"", description:"", phone:"", categoryDescription:""};
    body.publicationTitle= publication.form.value.title;
    body.description= publication.form.value.description;
    body.phone= publication.form.value.contact;
    body.categoryDescription= publication.form.value.type;


    let response = this.http.post<any>('api/v1/rest/publication',body,{headers});
    response.subscribe((data)=>console.log(data)
    );

  }
  constructor(private http:HttpClient){}

  ngOnInit(): void{
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNjg0OTc5NDgxLCJleHAiOjE2ODUwMTU0ODF9.6YTeMKYU0o2ggcjlrrW_7ofrT9bZRiRRDU9vVNm4aTA'
    const headers = { 'Authorization': 'Bearer '+token}
    let response = this.http.get<any>('api/v1/rest/publicationType',{headers});
    response.subscribe((data)=>this.type = data);
  }

}
