import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index.component';
import { RestaurantListComponent } from './restaurantList.component';
import { ProductsComponent } from './products.component';
import { FormComponent } from './form.component';
import { RequestComponent } from './request.component';
import { ProfileComponent} from './profile.component';
import { ListRequestPersonComponent} from './listRequestPerson.component';


const appRoutes = [
    { path: '', component: IndexComponent },
    { path: 'restaurantList', component: RestaurantListComponent },
    { path: 'signUp', component: FormComponent },
    { path: 'products/:id', component: ProductsComponent },
    { path: 'request/:id', component: RequestComponent},
    { path: 'editProfile', component: ProfileComponent},
    { path: 'requests', component: ListRequestPersonComponent}
]

export const routing = RouterModule.forRoot(appRoutes);