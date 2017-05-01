import { Component, OnInit} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
    moduleId: module.id,
    selector: 'restaurantList',
    templateUrl: 'restaurantList.template.html'
})

export class RestaurantListComponent implements OnInit{

    restaurants: Restaurant[];

    constructor(private restaurantService: RestaurantService, private sanitizer:DomSanitizer) { }

    ngOnInit(){
      this.restaurantService.getRestaurants(1).subscribe(
        restaurants => this.loadRestaurants(restaurants),
        //restaurants => console.log(restaurants),
        error => console.log(error)
      );
       console.log(this.restaurants);

     
      console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    loadRestaurants(restaurants){
      this.restaurants = restaurants;
      for(var i=0;i<restaurants.length;i++){
        this.restaurants[i].imageSafe = this.sanitizer.bypassSecurityTrustUrl(this.restaurants[i].image);
      }
    }
}