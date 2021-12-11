import { Product } from './Product';

export class CartItem {
  id!: number;
  quantity!: number;
  total!: number;
  description!: string;
  product!: Product;
}
