import { Injectable } from '@angular/core';
import { trainerModel } from '../model/trainer.model';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  trainers:trainerModel[]=[
    new trainerModel('Bhushan','Mumbai','Cloud',9876666666,'bhush@gmail.com'),
    new trainerModel('Naman','Mumbai','Cloud',9899996666,'nams@gmail.com'),
    new trainerModel('Isha','Mumbai','Cloud',8976666666,'ishh@gmail.com'),
    new trainerModel('Aakash','Kolkata','Java',7776666666,'kash@hot.com'),
    new trainerModel('Aman','Pune','ML',8876666666,'aman@yahoo.com')
  ];

  constructor() { }

  addTrainer(newTrainer:trainerModel){
    this.trainers.push(newTrainer);
  }

  listTrainer(){
    return this.trainers;
  }

  deleteTrainer(index:number){
    return this.trainers.splice(index,1);
  }

  sortByName(){
    return this.trainers.sort((x,y) => x.name > y.name ? 1 : ((x.name<y.name) ? -1 : 0));
  }

  sortByBranch(){
    return this.trainers.sort((x,y) => x.branch > y.branch ? 1 : ((x.branch<y.branch) ? -1 : 0));
  }

  sortByCity(){
    return this.trainers.sort((x,y) => x.city > y.city ? 1 : ((x.city<y.city) ? -1 : 0));   
  }

  sortByMobile(){
    return this.trainers.sort((x,y) => x.mobile > y.mobile ? 1 : ((x.mobile<y.mobile) ? -1 : 0));   
  }

  sortByEmail(){
    return this.trainers.sort((x,y) => x.mail > y.mail ? 1 : ((x.mail<y.mail) ? -1 : 0));      
  }

  searchByCity(cname:string){
    return this.trainers.filter(x=>x.city==cname);
  }

  searchByBranch(bname:string){
    return this.trainers.filter(x=>x.branch==bname);
  }
}
