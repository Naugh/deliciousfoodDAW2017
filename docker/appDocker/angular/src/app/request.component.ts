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
        
  /*      restaurantService.getRestaurant(this.id).subscribe(
            data => this.restaurant = data,
            error => console.error(error)

        ) */
        
    }
    ngOnInit(){
        this.total = JSON.parse(sessionStorage.getItem("total"));
        this.selects = JSON.parse(sessionStorage.getItem("selects")); 
  //      this.person = JSON.parse(sessionStorage.getItem("person"));
        if(this.loginService.isPersonLogged()){
           this.person = this.loginService.getPersonLogged();
        }
    }


  newRequest(){
        
        let request: Request={
            namePerson: this.person.name,
            surnames: this.person.surnames,
            address: this.person.address,
            phonePerson: this.person.phone,
            postal: this.person.postalCode,
            price: this.total,
            idRestaurant: this.id,
            products: this.selects
        };
    

        this.requestService.newRequest(request).subscribe(
            data => console.log(data),
            error => console.error('Error creating new request: ' + error)
        );

        this.router.navigate(['/request']);

        
  
  }

}