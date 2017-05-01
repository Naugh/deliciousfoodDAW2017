import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';



@Injectable()
export class RestaurantService {

    constructor(private http: Http) { }
    
    getRestaurants(page: number) {
        let url = 'https://localhost:8443/api/restaurants/?page='+page+'&size=10';
		//https://localhost:8443/api/restaurants/?page=1&size=10
		return this.http.get(url)
			.map(response => response.json()["content"])
			.catch(error => this.handleError(error));
	}

	getRestaurant(id: number | string){
		let url = 'https://localhost:8377/restaurantList';
		return this.http.get(url + id)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

    private handleError(error: any) {
		console.log("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}