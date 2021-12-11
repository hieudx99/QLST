import { CartItem } from './CartItem';
import { Customer } from './Customer';

export class ShoppingCart {
  id!: number;
  total!: number;
  paymentStat!: string;
  listCartItem!: CartItem[];
  customer!: Customer;
}
