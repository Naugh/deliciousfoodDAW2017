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
    public restaurant: boolean;
    public person: boolean;

    constructor(private loginService: LoginService,private router: Router) {
        this.changeHeader();
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
        this.router.navigate['/restaurantList'];
    }
    changeHeader(){
        this.restaurant = this.loginService.isRestaurantLogged();
        this.person = this.loginService.isPersonLogged();
    }

    restaurantList(){
        this.router.navigate['/restaurantList'];
    }

    editProfile(){
        this.router.navigate['/editProfile'];
    }
    logout(){
        this.loginService.logout().subscribe(
            u => {
                console.log(u);
                this.changeHeader();   
            }
        );
        this.router.navigate['/restaurantList'];
    }
}