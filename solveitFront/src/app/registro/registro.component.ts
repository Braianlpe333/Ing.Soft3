
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import {HttpClient} from '@angular/common/http'
export interface User{
  name :string;
  lastName: string;
  password:string;
  email: string;
  passwordRepeat:string;
  phoneNumber:number;
  employmentField:string;
}



@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {
  user!: FormGroup;
  ngOnInit() {
    this.user =  new FormGroup({
      name: new FormControl("", [Validators.required, Validators.minLength(2)]),
      lastName: new FormControl(""),
      email : new FormControl(""),
      password: new FormControl(""),
      passwordRepeat: new FormControl(""),
      phoneNumber: new FormControl(0),
      employmentField: new FormControl("")
    });
  }




  constructor(private http:HttpClient){}
  subtmit(user: any){
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNjg1NDE1MDI5LCJleHAiOjE2ODU0NTEwMjl9.v2ntpaWP1VaXuLpfUUd0EqSXDdZ69QvlxXUHkbtVK6I'
    const headers = { 'Authorization': 'Bearer '+token}
    var body1 = {name:"",surname:"",email:"",password:"",phone:"",employmentField:""}
    body1.name =  user.get('name').value;
    body1.surname =  user.get('lastName').value;
    body1.email =  user.get('email').value;
    body1.password =  user.get('password').value;
    body1.phone =  user.get('phone').value;
    body1.employmentField =  user.get('employmentField').value;
    console.log(body1);
    
    let response = this.http.post<any>("api/v1/rest/user", body1, {headers})
    response.subscribe((data)=>console.log(data))
    var body2 = {username:"", password:""}
    body2.username = user.email;
    body2.password = user.password;
    let response2 = this.http.post<any>("api/v1/rest/user", body2, {headers})
  }

}
