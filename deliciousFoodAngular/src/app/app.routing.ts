import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index.component';
import { RestaurantListComponent } from './restaurantList.component';
import { ProductsComponent } from './products.component';
import { FormComponent } from './form.component';
import { RequestComponent } from './request.component';

const ROOT = 'new/';

const appRoutes = [
    { path: '', component: IndexComponent },
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: 'restaurantList', component: RestaurantListComponent },
    { path: 'signUp', component: FormComponent },
    { path: 'products/:id', component: ProductsComponent },
    { path: 'request/:id', component: RequestComponent}
]

export const routing = RouterModule.forRoot(appRoutes);