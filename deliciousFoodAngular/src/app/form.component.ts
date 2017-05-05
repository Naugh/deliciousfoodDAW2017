import { Component, OnInit } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'formSignUp',
    templateUrl: 'form.template.html'
})

export class FormComponent implements OnInit {
    private client: boolean;
    private name: string;
    private email: string;
    private password: string;
    private surnames: string;
    private phone: string;
    private address: string;
    private postalCode: string;
    private categories: [
        {name:"Pizza", checked:false},
        {name:"Hamburguesa", checked:false},
        {name:"Japonesa", checked:false},
        {name:"Española", checked:false},
        {name:"Vegetariana", checked:false},
        {name:"China", checked:false},
        {name:"Italiana", checked:false},
        {name:"Turca", checked:false},
        {name:"India", checked:false}
    ];

    constructor() { }

    ngOnInit() {
        this.client=true;
        console.log(this.categories);
     }

}