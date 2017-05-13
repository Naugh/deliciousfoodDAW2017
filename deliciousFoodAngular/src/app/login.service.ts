import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

const URL = 'http://localhost:8080/api/login';

@Injectable()
export class LoginService {

    user;

    constructor(private http: Http) { }
    
    login(email:string, password:string){
        const headers = new Headers({
            'Authorization': 'Basic ' + utf8_to_b64(email + ':' + password),
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        /*return this.http.get(URL, options)
			.map((response: Response) => {
                response.json();
                let user = response.json();
                console.log(user);
                if (user){
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            })
			.catch(error => this.handleError(error));*/

        return this.http.get(URL, options).map(
        response => {
            this.processLogInResponse(response);
            return this.user;
            }
        );
    }

    private processLogInResponse(response) {
        this.user = response.json();
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
