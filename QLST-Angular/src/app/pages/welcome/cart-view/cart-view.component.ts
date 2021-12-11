import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/models/CartItem';
import { Customer } from 'src/app/models/Customer';
import { OrderBill } from 'src/app/models/OrderBill';
import { PaymentMethod } from 'src/app/models/PaymentMethod';
import { ShoppingCart } from 'src/app/models/ShoppingCart';
import { Voucher } from 'src/app/models/Voucher';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.less'],
})
export class CartViewComponent implements OnInit {
  shoppingCart!: ShoppingCart;
  customer!: Customer;
  listCartItem!: CartItem[];
  total = 0;
  voucher!: Voucher;
  listPayment!: PaymentMethod[];

  form: any = {
    fullname: '',
    phoneNum: '',
    city: '',
    district: '',
    address: '',
    paymentMethod: '',
    voucher: '',
  };
  constructor(
    private service: ServiceService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.retrieveData();
  }
  retrieveData() {
    this.customer = JSON.parse(this.storageService.getCustomer());
    this.service.getShoppingCart(this.customer.id).subscribe(
      (data) => {
        this.shoppingCart = data;
        this.listCartItem = data.listCartItem;
        this.total = this.shoppingCart.total;
      },
      (error) => {
        console.log(error);
      }
    );
    this.service.getListPayment().subscribe((data) => {
      this.listPayment = data;
    });
  }

  onSubmit() {
    // const voucher_temp = new Voucher();
    // voucher_temp.code = this.form.voucher;
    // this.service.checkVoucher(voucher_temp.code).subscribe(
    //   (data) => {
    //     this.voucher = data;
    //     console.log(this.voucher);
    //     if (this.voucher) {
    //       this.total = this.total - (this.total * this.voucher.discount) / 100;
    //     } else {
    //       Swal.fire('Invalid voucher');
    //       return;
    //     }
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );

    const orderBill = new OrderBill();
    orderBill.total = this.total;
    orderBill.bill_type = 'ONLINE';
    orderBill.ship_to = this.form.address;
    orderBill.ship_stat = 'P';
    orderBill.payment_stat = 'P';
    const paymentMethod = new PaymentMethod();
    paymentMethod.type = this.form.paymentMethod;
    orderBill.paymentMethod = paymentMethod;
    orderBill.voucher = this.voucher;
    orderBill.shoppingCart = this.shoppingCart;
    orderBill.customer = this.customer;

    console.log(this.form);
    console.log(orderBill);

    var result: boolean;
    this.service.addBill(orderBill).subscribe(
      (data) => {
        result = data;
        console.log(data);
        console.log(result);
        if (result === true) {
          Swal.fire('Order Successfully');
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
