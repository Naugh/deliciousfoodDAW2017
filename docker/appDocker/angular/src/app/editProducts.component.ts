import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { Component, Input, OnInit} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'productsEdit',
    templateUrl: 'editProducts.template.html'
})

export class EditProductsComponent implements OnInit{

    private restaurant: Restaurant;
    private products: Product[];

    private name: string;
    private price: number;
    private description: string;

    constructor(private router: Router, private restaurantService: RestaurantService) {} 

    ngOnInit(){
        this.restaurantService.getProductsAll().subscribe(
            data =>{
                this.products = data;
            },
            error => console.error(error)
        ) 
    }

    removeProduct(i:number){
        this.products.splice(i,1);
    }

    addProduct(){
        let product:Product = {
            name: this.name,
            description: this.description,
            price: this.price
        }
        this.products.push(product);
        this.name=undefined;
        this.price=undefined;
        this.description=undefined;
    }
   
    save(){
        this.restaurantService.saveProducts(this.products).subscribe(
            data => console.log(data),
            error => console.log(error)
        );
    }
}