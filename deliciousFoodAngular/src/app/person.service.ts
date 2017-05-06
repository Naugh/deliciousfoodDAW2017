import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Person } from './person.model';

const URL = 'https://localhost:8443/api/person';

@Injectable()
export class PersonService {

    constructor(private http: Http) { }
    
    addPerson(person: Person) {
		return this.http.post(URL, person)
			.map(response => response.json())
			.catch(error => this.handleError(error));
	}

    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}