import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { DatePipe } from '@angular/common';

@Injectable({
    providedIn: 'root'
})

export class BusService{

    temp:any;
    //Dependency Injection
    constructor(private myhttp:HttpClient,private datepipe:DatePipe){}

    getAllBuses(){
        return this.myhttp.get('http://localhost:9085/brs/showbuses');
    }

    getSources(){
        return this.myhttp.get('http://localhost:9085/brs/getsources');
    }
    getDestinations(){
        return this.myhttp.get('http://localhost:9085/brs/getdestinations');
    }
    addBus(data:any){
        //For RequestBody
        //return this.myhttp.post('http://localhost:9088/product/add',data);
        
        //For Model Attribute
        let form=new FormData();
        form.append("busName", data.busName);
        form.append("busType", data.busType);
        form.append("busClass", data.busClass);
        form.append("source", data.source);
        form.append("destination", data.destination);
        form.append("startTime", data.startTime);
        form.append("endTime", data.endTime);
        form.append("costPerSeat", data.costPerSeat);
        form.append("noOfSeats", data.noOfSeats);
        return this.myhttp.post('http://localhost:9085/brs/addbusdetails', form);

    }

    deleteBus(id:number){ 
        return this.myhttp.delete("http://localhost:9085/brs/deletebus?busId="+id);
    }

    showRunningBuses(src:string,dest:string,journeydate:any){
        console.log(dest)
        console.log("http://localhost:9085/brs/showrunningbuses?source="+src+"&destination="+dest+"&journeydate="+journeydate);
        return this.myhttp.get("http://localhost:9085/brs/showrunningbuses?source="+src+"&destination="+dest+"&journeydate="+journeydate);
    }

}