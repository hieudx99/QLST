import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/models/CartItem';
import { Customer } from 'src/app/models/Customer';
import { Product } from 'src/app/models/Product';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-detail-view',
  templateUrl: './product-detail-view.component.html',
  styleUrls: ['./product-detail-view.component.less'],
})
export class ProductDetailViewComponent implements OnInit {
  product!: Product;
  customer!: Customer;
  quantity = 1;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private service: ServiceService
  ) {}

  ngOnInit(): void {
    console.log('product detail view');
    this.product = JSON.parse(this.storageService.getProduct());
    this.customer = JSON.parse(this.storageService.getCustomer());
  }

  increaseQuantity() {
    if (this.quantity >= this.product.nbr_left) {
      Swal.fire('Only ' + this.product.nbr_left + ' items left');
    } else {
      this.quantity++;
    }
  }
  decreaseQuantity() {
    if (this.quantity <= 1) {
      Swal.fire('Quantity can not smaller than 1');
    } else {
      this.quantity--;
    }
  }

  addToCart() {
    const cartitem = new CartItem();
    cartitem.product = this.product;
    cartitem.quantity = this.quantity;
    cartitem.description = '';
    cartitem.total = this.quantity * this.product.unitPrice;
    var result: boolean;
    this.service.addCartItem(cartitem).subscribe(
      (data) => {
        result = data;
        console.log(data);
        console.log(result);
        if (result === true) {
          Swal.fire('Added item to cart');
        } else {
          Swal.fire('error');
        }
      },
      (error) => {
        console.log(error);
        Swal.fire('error');
      }
    );
  }
}
