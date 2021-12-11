import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BillDetailComponent } from './bill-detail/bill-detail.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { CustomerHomeViewComponent } from './customer-home-view/customer-home-view.component';
import { ImportHistoryComponent } from './import-history/import-history.component';
import { ListSupplierStatComponent } from './list-supplier-stat/list-supplier-stat.component';
import { ProductDetailViewComponent } from './product-detail-view/product-detail-view.component';
import { ProfileComponent } from './profile/profile.component';
import { SupplierStatViewComponent } from './supplier-stat-view/supplier-stat-view.component';
import { ViewStatHomeViewComponent } from './view-stat-home-view/view-stat-home-view.component';
import { WelcomeComponent } from './welcome.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'product', component: CustomerHomeViewComponent },
  { path: 'productdetail', component: ProductDetailViewComponent },
  { path: 'shoppingcart', component: CartViewComponent },
  { path: 'viewstathome', component: ViewStatHomeViewComponent },
  { path: 'supplierstat', component: SupplierStatViewComponent },
  { path: 'listsupplierstat', component: ListSupplierStatComponent },
  { path: 'importhistory/:id', component: ImportHistoryComponent },
  { path: 'billdetail/:id', component: BillDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WelcomeRoutingModule {}
