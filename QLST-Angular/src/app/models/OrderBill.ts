import { Customer } from './Customer';
import { PaymentMethod } from './PaymentMethod';
import { Shipper } from './Shipper';
import { ShoppingCart } from './ShoppingCart';
import { Staff } from './Staff';
import { Voucher } from './Voucher';

export class OrderBill {
  id!: number;
  date!: string;
  total!: number;
  bill_type!: string;
  ship_to!: string;
  ship_stat!: string;
  payment_stat!: string;
  paymentMethod!: PaymentMethod;
  voucher!: Voucher;
  shipper!: Shipper;
  checker!: Staff;
  shoppingCart!: ShoppingCart;
  customer!: Customer;
}
