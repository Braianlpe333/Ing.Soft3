import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  product: any;
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
      const headers = { 'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNjg0Nzg5MzI2LCJleHAiOjE2ODQ4MjUzMjZ9.hbvo-LJ8nnxmA7ohjVfrNQdeh6CyvYRWbnFvqSrUYNg' }
      let response = this.http.get<any>('api/v1/rest/publication', { headers });
      response.subscribe((data)=>this.product = this.product = data.data
      );
  }

}
