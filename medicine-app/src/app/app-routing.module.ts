import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayMedicineComponent } from './components/display-medicine/display-medicine.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceorderComponent } from './components/placeorder/placeorder.component';
import { ResultComponent } from './components/result/result.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: 'display', component : DisplayMedicineComponent},
  {path: 'home', component : HomeComponent},
  {path: 'placeorder', component : PlaceorderComponent},
  {path: 'result', component : ResultComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
