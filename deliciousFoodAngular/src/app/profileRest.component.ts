import { Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';
import { Restaurant } from './restaurant.model';



@Component({
    moduleId: module.id,
    selector: 'profileRest',
    templateUrl: 'profileRest.template.html'
  
})

export class ProfileRestComponent implements OnInit{

    private restaurant: Restaurant;
    private name: string;
    private password: string;
    private email: string;
    private address: string;
    private phone: string;
    private postalCode: string;
    private image?: string;

    constructor ( private router: Router) {}

    ngOnInit(){
        this.restaurant = JSON.parse(sessionStorage.getItem("restaurant"));
        this.name = this.restaurant.name;
        this.password= this.restaurant.password;
        this.email= this.restaurant.email;
        this.address= this.restaurant.address;
        this.phone= this.restaurant.phone;
        this.postalCode= this.restaurant.postalCode;
        
    }

    saveData(){
        
        this.restaurant.name = this.name;
        this.restaurant.password= this.password;
        this.restaurant.email= this.email;
        this.restaurant.address= this.address;
        this.restaurant.phone= this.phone;
        this.restaurant.postalCode= this.postalCode;
        this.restaurant.image= this.image;
        
        sessionStorage.setItem("restaurant", JSON.stringify(this.restaurant));
        this.router.navigate(['/']);

    }

}