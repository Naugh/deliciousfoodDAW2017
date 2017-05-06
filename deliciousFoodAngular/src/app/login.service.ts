import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

const URL = 'https://localhost:8443/api/login';

@Injectable()
export class LoginService {

    constructor(private http: Http) { }
    
    login(email:string, password:string){
        const headers = new Headers({
            'Authorization': 'Basic ' + utf8_to_b64(email + ':' + password),
            'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
        });

        const options = new RequestOptions({ headers: headers, withCredentials: true });

        return this.http.get(URL, options)
			.map((response: Response) => {
                response.json();
                let user = response.json();
                console.log(user);
                if (user){
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            })
			.catch(error => this.handleError(error));
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
