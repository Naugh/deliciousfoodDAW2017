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

    private restaurants: Restaurant[];
    private page: number;
    private spinner: boolean;
    private loadButton: boolean;

    constructor(private restaurantService: RestaurantService) {}

    ngOnInit(){
      this.spinner = false;
      this.page=0;
      this.restaurants = new Array;
      this.loadRestaurants();
    }  
      

    loadRestaurants(){
      this.loadButton=false;
      this.spinner=true;
      this.restaurantService.getRestaurants(this.page).subscribe(
        data => this.getData(data),
        error => console.log(error)
      );
      this.page++;      
    }

    getData(data){
      this.restaurants = this.restaurants.concat(data["content"]);
      this.spinner = false;
      this.loadButton = !data["last"];
    }
}