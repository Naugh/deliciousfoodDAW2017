import { Component, OnInit} from '@angular/core';

import { Product} from './product.model';



@Component({
    moduleId: module.id,
    selector: 'editProducts',
    templateUrl: 'editProducts.template.html'
  
})

export class EditProductsComponent implements OnInit{

    private products: Product[];

    constructor () {

    this.products = new Array;


    }

    ngOnInit(){
        

    }



}