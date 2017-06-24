import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { Restaurant } from './restaurant.model';
import { Person } from './person.model';


const URL = 'http://localhost:8080/api/';

const RESTAURANT = 'ROLE_RESTAURANT';
const PERSON = 'ROLE_PERSON';

@Injectable()
export class LoginService {

    constructor(private http: Http) { }
    
    login(email:string, password:string){
        const headers = new Headers({
            'Authorization': 'Basic ' + utf8_to_b64(email + ':' + password),
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        return this.http.get(URL + "login", options).map(
        response => {
            this.processLogInResponse(response);
            return response.json();
            }
        );
    }

    private processLogInResponse(response) {
        let role = response.json().roles[0];
        if(role === RESTAURANT){
            let restaurant: Restaurant = response.json();
            sessionStorage.setItem("restaurant", JSON.stringify(restaurant));
        }else if(role === PERSON){
            let person: Person = response.json();
            sessionStorage.setItem("person", JSON.stringify(person));
        }
    }

    logout() {
       return this.http.get(URL + "logout", { withCredentials: true}).map(
        response => {
            sessionStorage.removeItem("restaurant");
            sessionStorage.removeItem("person");
            return response;
            }
        );
    }

    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text());
    }

    getRestaurantLogged(){
        let restaurant:Restaurant = JSON.parse(sessionStorage.getItem("restaurant"));
        return restaurant;
    }

    getPersonLogged(){
        let person:Person = JSON.parse(sessionStorage.getItem("person"));
        return person;
    }

    isPersonLogged(){
        return this.getPersonLogged()!=undefined;
    }

    isRestaurantLogged(){
        return this.getRestaurantLogged()!=undefined;
    }

    test(){
        console.log("Persona --> " + sessionStorage.getItem("person"));
        console.log("Restaurante --> " + sessionStorage.getItem("restaurant"));

        console.log("Persona --> ");
        console.log(this.getPersonLogged());
        console.log("Restaurante --> ")
        console.log(this.getRestaurantLogged());
    }
    
}

function utf8_to_b64(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
        return String.fromCharCode(<any>'0x' + p1);
    }));
}
