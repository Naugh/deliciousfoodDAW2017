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
    private restaurant: boolean;
    private person: boolean;

    constructor(private loginService: LoginService) {
        this.restaurant = false;
        this.person = false;
     }

    login(event: any, username: string, password: string){
        event.preventDefault();

    this.loginService.login(username, password).subscribe(
      u =>{
          console.log(u);
          this.changeHeader();
      },
      error => alert('Invalid user or password')
    );
}
    changeHeader(){
        this.restaurant = this.loginService.restaurant!=undefined;
        this.person = this.loginService.person!=undefined;
    }

}