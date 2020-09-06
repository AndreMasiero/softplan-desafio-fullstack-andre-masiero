import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {UserListComponent} from './user/list/user-list.component';
import {UserNewComponent} from './user/new/user-new.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'user', component: UserListComponent},
  {path: 'user/new', component: UserNewComponent},
  {path: 'user/new/:id', component: UserNewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
