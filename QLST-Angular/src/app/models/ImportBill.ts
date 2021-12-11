import { ImportBillDetail } from './ImportBillDetail';
import { PaymentMethod } from './PaymentMethod';
import { Staff } from './Staff';
import { Supplier } from './Supplier';

export class ImportBill {
  id!: number;
  date!: string;
  total!: number;
  paymentMethod!: PaymentMethod;
  listImportBillDetail!: ImportBillDetail[];
  supplier!: Supplier;
  staff!: Staff;
}
