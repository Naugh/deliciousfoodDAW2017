import { Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';
import { RequestService } from './request.service';

import { Request } from './request.model';
import { Person } from './person.model';


@Component({
    moduleId: module.id,
    selector: 'listRequestPerson',
    templateUrl: 'listRequestPerson.template.html'
  
})

export class ListRequestPersonComponent implements OnInit{

    private requests: Request[];
    private person: Person;

    constructor (private requestService: RequestService) {

        this.requests = new Array;
        
        requestService.getRequestsPerson().subscribe(
            data => this.requests = data,
            error => console.error(error)
        ) 

       

    }

    ngOnInit(){
        this.person = JSON.parse(sessionStorage.getItem("person"));
        
    }

    examineProduct(r: Request){

    }


}