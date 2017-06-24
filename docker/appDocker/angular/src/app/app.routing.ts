import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index.component';
import { RestaurantListComponent } from './restaurantList.component';
import { ProductsComponent } from './products.component';
import { FormComponent } from './form.component';
import { RequestComponent } from './request.component';
import { ProfileComponent} from './profile.component';
import { ListRequestPersonComponent} from './listRequestPerson.component';
import { EditProductsComponent} from './editProducts.component';
import { RequestEndComponent} from './requestEnd.component';
import { ProfileRestComponent} from './profileRest.component';
import { ListRequestRestComponent} from './listRequestRest.component';


const appRoutes = [
    { path: '', component: IndexComponent },
    { path: 'restaurantList', component: RestaurantListComponent },
    { path: 'signUp', component: FormComponent },
    { path: 'products/:id', component: ProductsComponent },
    { path: 'request/:id', component: RequestComponent},
    { path: 'editProfile', component: ProfileComponent},
    { path: 'requests', component: ListRequestPersonComponent},
    { path: 'productsEdit', component: EditProductsComponent},
    { path: 'request', component: RequestEndComponent},
    { path: 'profile', component: ProfileRestComponent},
//<<<<<<< HEAD
    { path: 'requestsList', component: ListRequestRestComponent},
//=======
    { path: 'logout', redirectTo: '' },
    { path: '**', redirectTo: '' }
//>>>>>>> origin/master
]

export const routing = RouterModule.forRoot(appRoutes);