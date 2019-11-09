import { Component, OnInit} from '@angular/core';
import { ProductService } from './_service/app.productservice';
import { Product } from './_model/app.product';

@Component({
    selector: 'prod',
    templateUrl: 'app.product.html'
})

export class ProductComponent implements OnInit {
    // prodId:number;
    // prodName:String;
    // prodCost:number;
    products:Product[] = [];
    // update:any;

    constructor(private service:ProductService){
        console.log("In Constructor .......")
    }
    ngOnInit(){
        this.service.getAllData().subscribe((data:Product[]) =>this.products = data);
    }

    // addProduct():any{
    //     this.products.push({prodId: this.prodId, prodName:this.prodName, prodCost:this.prodCost});
    // }

    // updateProduct(pro:any):any{
    //     this.update ={prodId:pro.prodId, prodCost:pro.prodCost, prodName:pro.prodName};
    // }

    // updateProductSubmit():any{
    //     for(let i = 0; i<this.products.length;i++){
    //         if(this.products[i].prodId == this.update.prodId){
    //             this.products[i] = this.update;
    //         }
    //     }
    //     this.update = null;
    // }
    // deleteProduct(prod:any):any{
    //     this.products.splice(this.products.indexOf(prod), 1);
    // }

    

}