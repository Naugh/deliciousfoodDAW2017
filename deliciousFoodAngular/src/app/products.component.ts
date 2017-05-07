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

    restaurant: Restaurant;
    request: Request;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService) {

        let id = activatedRoute.snapshot.params['id'];
      
        restaurantService.getRestaurant(id).subscribe(
            restaurant => this.restaurant = restaurant,
            error => console.error(error)
        ) 
         // let products = this.restaurant.products;
} 

 addProduct(){
    
 }

/*newRequest(){
    
    let id = 1;
    this.router.navigate(['/request/:id']);
} */


   
}