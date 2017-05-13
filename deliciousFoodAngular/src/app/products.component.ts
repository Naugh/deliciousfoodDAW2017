import { Component} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Request} from './request.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { RequestService } from './request.service';

@Component({
    moduleId: module.id,
    selector: 'products',
    templateUrl: 'products.template.html'
  
})

export class ProductsComponent{

    private restaurant: Restaurant;
    private request: Request;
    private products: Product[];
    public selects: Product[];
    private total: number;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService, 
                private requestService: RequestService) {

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
        if (p === product && exist === false){
            exist = true;
            p.amount = p.amount + 1;
           
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

finalizar(){
    this.router.navigate(['/request/:id']);
}

/*removeProduct(p: Product){
    this.selects[p.id].remove();
} */

/*newRequest(){
   
    this.request.products = this.selects;
    this.requestService.addRequest(request);
    let id = this.restaurant.id;
    this.router.navigate(['/request/:id']);
} */


   
}