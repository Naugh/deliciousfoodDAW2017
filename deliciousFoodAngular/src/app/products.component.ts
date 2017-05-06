import { Component} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';

@Component({
    moduleId: module.id,
    selector: 'products',
    templateUrl: 'products.template.html'
  
})

export class ProductsComponent{

    restaurant: Restaurant;

/*    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService) {

        let id = activatedRoute.snapshot.params['id'];
      
        restaurantService.getRestaurant(id).subscribe(
            restaurant => this.restaurant = restaurant,
            error => console.error(error)
        )
          let products = this.restaurant.products;


 } */



   
}