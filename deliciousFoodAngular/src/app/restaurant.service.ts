import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Restaurant} from './restaurant.model';

const URL = 'https://localhost:8443/api/restaurant';

@Injectable()
export class RestaurantService {

    constructor(private http: Http) { }
    
    getRestaurants(page: number) {
        let url = 'https://localhost:8443/api/restaurants/?page='+page+'&size=10';
		return this.http.get(url)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

	addRestaurant(restaurant: Restaurant) {
		return this.http.post(URL, restaurant)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

	getProducts(id: number | string){
		let url = 'https://localhost:8443/api/products/';
		return this.http.get(url + id)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}