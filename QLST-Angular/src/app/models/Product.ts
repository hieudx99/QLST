import { Category } from './Category';

export class Product {
  id!: number;
  name!: string;
  unitPrice!: number;
  nbr_sold!: number;
  nbr_left!: number;
  desc!: string;
  size!: number;
  color!: string;
  image!: string;
  category!: Category;
}
