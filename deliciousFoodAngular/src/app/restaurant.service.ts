import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';



@Injectable()
export class RestaurantService {

    constructor(private http: Http) { }
    
    getRestaurants() {
        let url = 'http://localhost:4200/restaurantList';
		return this.http.get(url)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

	getRestaurant(id: number | string){
		let url = 'http://localhost:4200/restaurantList';
		return this.http.get(url + id)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}