import { Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';
import { Person } from './person.model';



@Component({
    moduleId: module.id,
    selector: 'profile',
    templateUrl: 'editProfile.template.html'
  
})

export class ProfileComponent implements OnInit{

    private person: Person;
    private name: string;
    private surnames: string;
    private password: string;
    private email: string;
    private address: string;
    private phone: string;
    private postalCode: string;

    constructor ( private router: Router) {}

    ngOnInit(){
        this.person = JSON.parse(sessionStorage.getItem("person"));
        this.name = this.person.name;
        this.surnames= this.person.surnames;
        this.password= this.person.password;
        this.email= this.person.email;
        this.address= this.person.address;
        this.phone= this.person.phone;
        this.postalCode= this.person.postalCode;
    }

    saveData(){
        
        this.person.name = this.name;
        this.person.surnames= this.surnames;
        this.person.password= this.password;
        this.person.email= this.email;
        this.person.address= this.address;
        this.person.phone= this.phone;
        this.person.postalCode= this.postalCode;
        
        sessionStorage.setItem("person", JSON.stringify(this.person));
        this.router.navigate(['/']);

    }

}