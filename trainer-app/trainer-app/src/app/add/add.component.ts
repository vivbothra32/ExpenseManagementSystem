import { Component, OnInit } from '@angular/core';
import { trainerModel } from '../model/trainer.model';
import { ServiceService } from '../service/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  addNewTrainer:trainerModel;
  cities:string[]=['Mumbai','Pune','Chennai','Kolkata','Delhi'];
  branches:string[]=['Java','Dotnet','Cloud','AI','ML'];

  constructor(private service:ServiceService, private route:Router) { 
    this.addNewTrainer=new trainerModel();
  }

  ngOnInit() {
  }

  addTrainer(){
    this.service.addTrainer(this.addNewTrainer);
    this.addNewTrainer=new trainerModel();
    this.route.navigate(['list']);
  }

}
