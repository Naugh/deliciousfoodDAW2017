import { Component, Input, OnInit} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Person } from './person.model';
import { Request} from './request.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { RequestService } from './request.service';
import { LoginService } from './login.service';
import { ProductsComponent } from './products.component';


@Component({
    moduleId: module.id,
    selector: 'request',
    templateUrl: 'request.template.html'
  
})

export class RequestComponent implements OnInit{

    
    private selects: Product[];
    private total: number;
    private person: Person;
    private req: Request;
    private restaurant: Restaurant;
    private id : number;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService, 
                private requestService: RequestService, private loginService: LoginService) {

        this.id = activatedRoute.snapshot.params['id'];
        
    }
    ngOnInit(){
        this.total = JSON.parse(sessionStorage.getItem("total"));
        this.selects = JSON.parse(sessionStorage.getItem("selects")); 
        this.person = JSON.parse(sessionStorage.getItem("person"));
        if(this.loginService.isPersonLogged()){
           this.person = this.loginService.getPersonLogged();
        }
        console.log(this.person);
    }


  newRequest(){
        
   /*     this.req.namePerson = this.person.name;
        this.req.surnames = this.person.surnames;
        this.req.address = this.person.address;
        this.req.phonePerson = this.person.phone;
        this.req.phoneRestaurant = this.restaurant.phone;
        this.req.postal = this.person.postalCode;
        this.req.price = this.total;
        this.req.idRestaurant = this.id; 
       

        let i: 0;
        for(let product of this.selects){
            
            this.req.products[i] = product;
            i++;
		}

        this.person.requests.push(this.req); */

        this.requestService.newRequest(this.req).subscribe(
            request => console.log("Request" + request) ,
            error => console.error('Error creating new request: ' + error)
        );

        this.router.navigate(['/request']);

        
  
  }

}