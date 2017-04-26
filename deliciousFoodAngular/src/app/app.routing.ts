import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index.component';

const appRoutes = [
    { path: '', component: IndexComponent }
]

export const routing = RouterModule.forRoot(appRoutes);