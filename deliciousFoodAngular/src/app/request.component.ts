import { Component, Input} from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RestaurantService } from './restaurant.service';
import { ProductsComponent } from './products.component';

@Component({
    moduleId: module.id,
    selector: 'request',
    templateUrl: 'request.template.html'
  
})

export class RequestComponent{

     @Input() 
    private selects: Product[];

    constructor () {}


  //esto cuando se confirma que el pedido va a la base de datos no antes
  //  requestList.push(request);
}