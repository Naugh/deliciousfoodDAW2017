import { Component} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Request} from './request.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';

@Component({
    moduleId: module.id,
    selector: 'products',
    templateUrl: 'products.template.html'
  
})

export class ProductsComponent{

    private restaurant: Restaurant;
    private request: Request;
    private products: Product[];
    private selects: Product[];
    private total: number;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService) {

        let id = activatedRoute.snapshot.params['id'];
        this.products= new Array;
        this.selects= new Array;
        
        restaurantService.getProducts(id).subscribe(
            data => this.products = data,
            error => console.error(error)
        ) 
         // let products = this.restaurant.products;
} 

 addProduct(p: Product){
     var exist: Boolean;
     exist = false;
     for (let product of this.selects){
        if (p === product){
            exist = true;
            p.amount = p.amount + 1;
           this.selects.push(p);
     }
    } 
   if (exist === false){
        p.amount = 1;
       this.selects.push(p);
        
    }
    this.calcularTotal();
}

calcularTotal(){
    this.total = 0;
    for (let product of this.selects){
        this.total = this.total + (product.price * product.amount);
    }
}

/*removeProduct(p: Product){
    this.selects[p.id].remove();
} */

/*newRequest(){
    
    let id = 1;
    this.router.navigate(['/request/:id']);
} */


   
}