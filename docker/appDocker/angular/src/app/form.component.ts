import { Component, OnInit } from '@angular/core';
import { Restaurant} from './restaurant.model';
import { Person } from './person.model';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonService } from './person.service';
import { RestaurantService } from './restaurant.service';

@Component({
    moduleId: module.id,
    selector: 'formSignUp',
    templateUrl: 'form.template.html'
})

export class FormComponent implements OnInit {
    private client: boolean;
    private name: string;
    private email: string;
    private password: string;
    private passwordConfirm: string;
    private surnames: string;
    private phone: string;
    private address: string;
    private postalCode: string;
    private imgBase64: string;
    /*private categories = [
        {name:"Pizza", checked:false},
        {name:"Hamburguesa", checked:false},
        {name:"Japonesa", checked:false},
        {name:"Española", checked:false},
        {name:"Vegetariana", checked:false},
        {name:"China", checked:false},
        {name:"Italiana", checked:false},
        {name:"Turca", checked:false},
        {name:"India", checked:false}
    ];*/

    constructor(private personService: PersonService, private restaurantService: RestaurantService, private router: Router) { }

    ngOnInit() {
        this.client=true;
    }

    handleFileSelect(evt){
      var files = evt.target.files;
      var file = files[0];
    
     if (files && file) {
        var reader = new FileReader();

        reader.onload =this._handleReaderLoaded.bind(this);

        reader.readAsBinaryString(file);
    }
  }
  
    _handleReaderLoaded(readerEvt) {
     var binaryString = readerEvt.target.result;
            this.imgBase64= btoa(binaryString);
    }

    signUp(){
        if(this.client){
           let person: Person = {
                name: this.name,
                surnames: this.surnames,
                password: this.password,
                email: this.email,
                address: this.address,
                phone: this.phone,
                postalCode: this.postalCode
           };
           this.personService.addPerson(person).subscribe(
               data => console.log(data),
               error => console.log(error)
           ); 
        }else{
            let restaurant: Restaurant = {
                name: this.name,
                password: this.password,
                email: this.email,
                address: this.address,
                phone: this.phone,
                postalCode: this.postalCode,
                image: this.imgBase64
           };
           this.restaurantService.addRestaurant(restaurant).subscribe(
               data => console.log(data),
               error => console.log(error)
           ); 
        }
        this.router.navigate(['/']);
    }


}