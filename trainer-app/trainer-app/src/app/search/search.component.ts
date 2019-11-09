import { Component, OnInit } from '@angular/core';
import { trainerModel } from '../model/trainer.model';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  trainers:trainerModel[];
  cityName:string;
  branchName:string;
  found:boolean;

  constructor(private service:ServiceService) { }

  ngOnInit() {
  }

  searchTrainerByCity(){
    this.trainers=this.service.searchByCity(this.cityName)
    if(this.trainers.length==0){
      alert("Trainer not found");
      this.found=false;
    }
    else
      this.found=true;
  }

  searchTrainerByBranch(){
    this.trainers=this.service.searchByBranch(this.branchName)
    if(this.trainers.length==0){
      alert("Trainer not found");
      this.found=false;
    }
    else
      this.found=true;
  }
}
