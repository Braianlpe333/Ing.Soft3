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

  ngOnInit(): void {
    this.initData();
  }

  async initData(){
    this.userName = "Nombre de usuario";
    let responseDataUser = await this.profileService.loadUserData(this.idUser).subscribe(res => {
      this.listPostings = res;
    });
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
