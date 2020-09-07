import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {UserListComponent} from './user/list/user-list.component';
import {UserNewComponent} from './user/new/user-new.component';
import {ProcessListComponent} from './process/list/process-list.component';
import {ProcessNewComponent} from './process/new/process-new.component';
import {ProcessDetailComponent} from './process/detail/process-detail.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'user', component: UserListComponent},
  {path: 'user/new', component: UserNewComponent},
  {path: 'user/new/:id', component: UserNewComponent},
  {path: 'process', component: ProcessListComponent},
  {path: 'process/new', component: ProcessNewComponent},
  {path: 'process/detail/:id', component: ProcessDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
