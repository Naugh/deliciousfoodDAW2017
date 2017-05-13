import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { Restaurant} from './restaurant.model';
import { Person} from './person.model';

const URL = 'http://localhost:8080/api/login';

const RESTAURANT = 'ROLE_RESTAURANT';
const PERSON = 'ROLE_PERSON';

@Injectable()
export class LoginService {

    restaurant:Restaurant;
    person:Person;

    constructor(private http: Http) { }
    
    login(email:string, password:string){
        const headers = new Headers({
            'Authorization': 'Basic ' + utf8_to_b64(email + ':' + password),
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        return this.http.get(URL, options).map(
        response => {
            this.processLogInResponse(response);
            return response.json();
            }
        );
    }

    private processLogInResponse(response) {
        let role = response.json().roles[0];
        if(role === RESTAURANT){
            this.restaurant = response.json();
        }else if(role === PERSON){
            this.person = response.json();
        }
    }

    logout() {
        localStorage.removeItem('currentItem');
    }

    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
    
}

function utf8_to_b64(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
        return String.fromCharCode(<any>'0x' + p1);
    }));
}
