import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile/profile.service';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  public idUser:number = 0; 
  public listPostings!: any[]; 
  public userName!:String;

  constructor(
    private profileService: ProfileService
  ){}
  product: any;
  user : any;
  ngOnInit(): void {
    this.initData();
  }

  async initData(){
    this.userName = "Nombre de usuario";
    let responseDataUser = await this.profileService.loadUserData(this.idUser).subscribe(res => {
      this.listPostings = res;
    });
  }

  async deleteAccount(){}

  async logOut(){}

}
