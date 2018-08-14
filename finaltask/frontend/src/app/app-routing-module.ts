import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './authorization/registration/registration.component';
import { SignInComponent } from './authorization/sign-in/sign-in.component';
import { CategoryComponent } from './category/category.component';
import { CharacteristicComponent } from './characteristic/characteristic.component';
import { ManufacturerComponent } from './manufacturer/manufacturer.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProductProfileComponent } from './product/product-profile/product-profile.component';
import { ProductComponent } from './product/product.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';

const routes: Routes = [
  { path: 'productProfile/:id', component: ProductProfileComponent },
  { path: '404', component: NotFoundComponent },
  { path: 'userProfile/:id', component: UserProfileComponent },
  { path: 'users', component: UserListComponent },
  { path: 'signUp', component: RegistrationComponent },
  { path: 'signIn', component: SignInComponent },
  { path: 'manufacturers', component: ManufacturerComponent },
  { path: 'categorys', component: CategoryComponent },
  { path: 'characteristics', component: CharacteristicComponent },
  { path: 'products', component: ProductComponent },
  { path: '', component: ProductComponent },
  { path: '**', redirectTo: '404' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule { }
