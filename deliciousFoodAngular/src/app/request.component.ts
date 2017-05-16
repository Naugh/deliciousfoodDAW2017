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
    private loginService: LoginService;
    private person: Person;
    private req: Request;
    private restaurant: Restaurant;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private restaurantService: RestaurantService, 
                private requestService: RequestService) {

        let id = activatedRoute.snapshot.params['id'];
        
        restaurantService.getRestaurant(id).subscribe(
            data => this.restaurant = data,
            error => console.error(error)
        ) 
        
    }
    ngOnInit(){
        this.total = JSON.parse(sessionStorage.getItem("total"));
        this.selects = JSON.parse(sessionStorage.getItem("selects")); 
        this.person = JSON.parse(sessionStorage.getItem("person"));
  /*      if(this.loginService.isPersonLogged()){
           this.person = this.loginService.getPersonLogged();
        
       } */ 
    }
    id?: number;
    namePerson: string;
    surnames: string;
    address: string;
    phonePerson: string;
    phoneRestaurant: string;
    postal: string;
    price: number;
    idRestaurant: number;
    delivered: boolean;
    products: Array<Product>;



  addRequest(){
        
        this.req.namePerson = this.person.name;
        this.req.surnames = this.person.surnames;
        this.req.phonePerson = this.person.phone;
        this.req.phoneRestaurant = this.restaurant.phone;
        this.req.postal = this.person.postalCode;
        this.req.price = this.total;
        this.req.idRestaurant = this.restaurant.id;
        this.req.address = this.person.address;

        let i: 0;
        for(let product of this.selects){
            
            this.req.products[i] = product;
            i++;
		}

        this.person.requests.push(this.req);

        this.requestService.newRequest(this.req).subscribe(
            request => this.router.navigate(['/request']),
            error => console.error('Error creating new book: ' + error)
        );


        
  
  }

}