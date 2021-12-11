import { Product } from './Product';

export class ImportBillDetail {
  id!: number;
  quantity!: number;
  total!: number;
  description!: string;
  product!: Product;
}
