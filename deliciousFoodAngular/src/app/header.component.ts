import { Component} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LoginService } from './login.service';

@Component({
    moduleId: module.id,
    selector: 'header-sel',
    templateUrl: 'header.template.html'
})

export class HeaderComponent{
    private username: string;
    private password: string;

    constructor(private loginService: LoginService) { }

    login(event: any, username: string, password: string){
        event.preventDefault();

    this.loginService.login(username, password).subscribe(
      u => console.log(u),
      error => alert('Invalid user or password')
    );
    }
}