import { NgModule } from '@angular/core';

import { WelcomeRoutingModule } from './welcome-routing.module';

import { DemoNgZorroAntdModule } from '../../ng-zorro-antd.module';
import { WelcomeComponent } from './welcome.component';
import { ProfileComponent } from './profile/profile.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CustomerHomeViewComponent } from './customer-home-view/customer-home-view.component';
import { ProductDetailViewComponent } from './product-detail-view/product-detail-view.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { ListSupplierStatComponent } from './list-supplier-stat/list-supplier-stat.component';
import { ImportHistoryComponent } from './import-history/import-history.component';
import { BillDetailComponent } from './bill-detail/bill-detail.component';

@NgModule({
  imports: [
    WelcomeRoutingModule,
    DemoNgZorroAntdModule,
    CommonModule,
    FormsModule,
  ],
  declarations: [
    WelcomeComponent,
    ProfileComponent,
    CustomerHomeViewComponent,
    ProductDetailViewComponent,
    CartViewComponent,
    ListSupplierStatComponent,
    ImportHistoryComponent,
    BillDetailComponent,
  ],
  exports: [WelcomeComponent],
})
export class WelcomeModule {}
