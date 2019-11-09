import { Component, OnInit } from '@angular/core';
import { trainerModel } from '../model/trainer.model';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  trainers:trainerModel[];

  constructor(private service:ServiceService) { }

  ngOnInit() {
    this.trainers=this.service.listTrainer();
  }

  delete(index:number){
    var ans=confirm("Are you sure you want to delete record?");
    if(ans)
      this.service.deleteTrainer(index);
  }

  sortByName(){
    return this.service.sortByName();
  }

  sortByBranch(){
    return this.service.sortByBranch();
  }

  sortByCity(){
    return this.service.sortByCity();
  }

  sortByMobile(){
    return this.service.sortByMobile();
  }

  sortByEmail(){
    return this.service.sortByEmail();
  }

}
