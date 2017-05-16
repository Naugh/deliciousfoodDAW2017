import { Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';
import { RequestService } from './request.service';

import { Request } from './request.model';
import { Restaurant } from './restaurant.model';


@Component({
    moduleId: module.id,
    selector: 'listRequestRest',
    templateUrl: 'listRequestRest.template.html'
  
})

export class ListRequestRestComponent implements OnInit{

    private requests: Request[];
    private restaurant: Restaurant;

    constructor (private requestService: RequestService) {

        this.requests = new Array;
        
        requestService.getRequestsPerson().subscribe(
            data => this.requests = data,
            error => console.error(error)
        ) 

       

    }

    ngOnInit(){
        this.restaurant = JSON.parse(sessionStorage.getItem("restaurant"));
        
    }



}