import { Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';


@Component({
    moduleId: module.id,
    selector: 'profile',
    templateUrl: 'editProfile.template.html'
  
})

export class ProfileComponent implements OnInit{

    

    constructor () {}

    ngOnInit(){

    }



}