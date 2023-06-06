import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile/profile.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  public idUser:number = 0; // esta variable debe jalar del localstorage el ID del user luego de haberse logueado.
  public listPostings!: any[]; //aqui se cargara cada post traido del back-end
  public userName!:String;

  constructor(
    private profileService: ProfileService, private http: HttpClient
  ){}
  product: any;
  user : any;
  ngOnInit(): void {
    this.initData();
  }

  async initData(){
    const token = sessionStorage.getItem('token');
    const username = sessionStorage.getItem('userName')
    const headers = { 'Authorization': 'Bearer '+token}
    let response = this.http.get<any>('api/v1/rest/publication', { headers });
    let response1 = this.http.get<any>('api/v1/rest/user/'+username,{ headers })
    response.subscribe((data)=>this.product = data.data);
    response1.subscribe((data)=>this.user=data.data[0])
    
    
    
  }

  async deleteAccount(){
    const token = sessionStorage.getItem('token');
    const userName = sessionStorage.getItem('userName');  
    let response =this.http.delete('/api/v1/rest/user/'+userName);
    if(response){
      this.logOut();
    }
  }

  async logOut(){
    
    sessionStorage.setItem('isRegisteredIn', 'false');
    sessionStorage.setItem('isLoggedIn', 'false');
    sessionStorage.setItem('token', '');
  }

}
