
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

}

