import { Component} from '@angular/core';

@Component({
    selector: 'car',
    templateUrl: 'app.showcar.html'
})

export class CarComponent  {
    options:any[] = [
        {id:0, name: "Select"},
        {id:1, name:"bmw"},
        {id:2, name:"audi"},
        {id:3, name:"ferrari"},
        {id:4, name:"tesla"},
        {id:5, name:"jaguar"}]
    selectedId:number = 0;
    pic:any = ""; 
    
    showPic(chosen:number){
        if(chosen == 0){
            this.pic = ""
        }
        else{
            this.pic = "/assets/"+ this.options[chosen].name + ".jpg"
        }
    }
}