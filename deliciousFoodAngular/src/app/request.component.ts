import { Component, Input, OnInit} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Person } from './person.model';
import { Request} from './request.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
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

    constructor () {}

    ngOnInit(){
        this.total = JSON.parse(sessionStorage.getItem("total"));
        this.selects = JSON.parse(sessionStorage.getItem("selects")); 
 /*       if(this.loginService.isPersonLogged()){
           this.person = JSON.parse(sessionStorage.getItem("person"));
        
        } */
    }


  //esto cuando se confirma que el pedido va a la base de datos no antes
  //  requestList.push(request);

  addRequest(r: Request){
  
  }

}