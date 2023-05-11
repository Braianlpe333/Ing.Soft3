import { Component } from '@angular/core';
import {PublicationTypeService} from '../publication-type.service';

@Component({
  selector: 'app-create-publication',
  templateUrl: './create-publication.component.html',
  styleUrls: ['./create-publication.component.css']
})
export class CreatePublicationComponent  {

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