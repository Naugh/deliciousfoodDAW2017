import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Request } from './request.model';

const URL = 'http://localhost:8080/api/request';

@Injectable()
export class RequestService {

    constructor(private http: Http) { }

    addRequest(request: Request){
        return this.http.post(URL, request)
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }



    private handleError(error : any){
        console.error(error);
        return Observable.throw("Server error (" + error.status + ") " + error.text())
    }
}