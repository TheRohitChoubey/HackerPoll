import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HackerDetailsComponent } from './hacker-details/hacker-details.component';
import { ProfileDetailComponent } from './profile-detail/profile-detail.component';


const routes: Routes = [
  {
    path: 'poll',
    component : HackerDetailsComponent
  },
  {
    path: 'login',
    component : LoginComponent
  },
  {
    path: 'user',
    component : ProfileDetailComponent
  },
  {
    path: '**',
    component : HackerDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
