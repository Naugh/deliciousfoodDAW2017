import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { IndexComponent } from './index.component';
import { FooterComponent } from './footer.component';
import { HeaderComponent } from './header.component';
import { RestaurantListComponent } from './restaurantList.component';
import { ProductsComponent } from './products.component';
import { FormComponent } from './form.component';
import { RequestComponent } from './request.component';


import { RestaurantService } from './restaurant.service';
import { RequestService } from './request.service';
import { PersonService } from './person.service';
import { LoginService } from './login.service';

import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    FooterComponent,
    HeaderComponent,
    RestaurantListComponent,
    FormComponent,
    ProductsComponent,
    RequestComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    routing,
    NgbModule.forRoot()
  ],
  providers: [
    RequestService,
    RestaurantService,
    PersonService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
