import { Component, OnInit} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';

@Component({
    moduleId: module.id,
    selector: 'restaurantList',
    templateUrl: 'restaurantList.template.html'
})

export class RestaurantListComponent implements OnInit{

    restaurants: Restaurant[];

    constructor(private restaurantService: RestaurantService) { }

    ngOnInit(){
      this.restaurantService.getRestaurants().subscribe(
        restaurants => this.restaurants = restaurants,
        error => console.log(error)
      );
    }
}