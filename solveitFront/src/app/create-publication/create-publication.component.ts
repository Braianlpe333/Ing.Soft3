import { Component, OnInit } from '@angular/core';
import {PublicationTypeService} from '../publication-type.service';
import { FormControl,FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-publication',
  templateUrl: './create-publication.component.html',
  styleUrls: ['./create-publication.component.css']
})
export class CreatePublicationComponent implements OnInit {

  submit(publication: any){
    console.log("Form submitted",publication);
    
  }
  constructor(private type:PublicationTypeService){}
  publicationType:any = [];
  ngOnInit(): void{
    this.type.getType().subscribe((allData)=>{
      this.publicationType = allData;
    });
  }

}