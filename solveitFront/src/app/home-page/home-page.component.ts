import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  product: any;
  
  

  constructor(private http: HttpClient) { }

  ngOnInit() {
      const headers = { 'Authorization': 'Bearer '}
      let response = this.http.get<any>('api/v1/rest/publication', { headers });
      response.subscribe((data)=>this.product = data.data);
  }

}
