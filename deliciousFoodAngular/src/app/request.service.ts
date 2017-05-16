import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Request } from './request.model';
import { Person } from './person.model';


const URL = 'http://localhost:8080/api/request';

@Injectable()
export class RequestService {

    constructor(private http: Http) { }

    newRequest(request: Request){
        let url = 'http://localhost:8080/api/request';
        return this.http.post(url, request, { withCredentials: true})
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }

    getRequests(){
        let url: 'http://localhost:8080/api/request/all';
        return this.http.get(url)
            .map(response => response.json())
            .catch(error => this.handleError(error));
    }

   

    private handleError(error : any){
        console.error(error);
        return Observable.throw("Server error (" + error.status + ") " + error.text())
    }
}