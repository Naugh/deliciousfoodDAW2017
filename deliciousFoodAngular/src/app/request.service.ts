import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Request } from './request.model';

const URL = 'https://localhost:8443/api/request';

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