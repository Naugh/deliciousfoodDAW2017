import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index.component';
import { RestaurantListComponent } from './restaurantList.component';
//import { ProductsComponent } from './products.component';

const appRoutes = [
    { path: '', component: IndexComponent },
    { path: 'restaurantList', component: RestaurantListComponent }//,
    //{ path: 'products/:id', component: ProductsComponent }
]

export const routing = RouterModule.forRoot(appRoutes);