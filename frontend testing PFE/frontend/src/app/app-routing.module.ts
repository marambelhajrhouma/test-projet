import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './Components/admin/dashboard/dashboard.component';
import { EditProfileComponent } from './Components/admin/edit-profile/edit-profile.component';
import { SignInComponent } from './Components/admin/sign-in/sign-in.component';
import { ClientSignUpComponent } from './Components/client/client-sign-up/client-sign-up.component';
import { ClientSignInComponent } from './Components/client/client-sign-in/client-sign-in.component';
import { HomePageComponent } from './Components/client/home-page/home-page.component';
import { AuthGuard } from './auth.guard';
import { ClientListComponent } from './Components/admin/client-list/client-list.component';
import { BassinComponent } from './Components/admin/bassin/bassin.component';

const routes: Routes = [
  //Les pages d'Admin
  { path: 'admin/dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'admin/signin', component: SignInComponent },
  { path: 'admin/edit-profile', component: EditProfileComponent, canActivate: [AuthGuard] },
  { path: 'admin/clients', component: ClientListComponent, canActivate: [AuthGuard] }, // Route pour la liste des clients
  { path: 'admin/bassin', component: BassinComponent },
  { path: 'client/signin', component: ClientSignInComponent },
  { path: 'client/signup', component: ClientSignUpComponent },
  { path: 'client/homepage', component: HomePageComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/admin/signin', pathMatch: 'full' }, // Redirection par défaut
  { path: '**', redirectTo: '/admin/signin' } // Redirection pour les routes inconnues
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }