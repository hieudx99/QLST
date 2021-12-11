import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../models/Product';
import { environment } from 'src/environments/environment';
import { Customer } from '../models/Customer';
import { CartItem } from '../models/CartItem';
import { StorageService } from './storage.service';
import { ShoppingCart } from '../models/ShoppingCart';
import { Voucher } from '../models/Voucher';
import { PaymentMethod } from '../models/PaymentMethod';
import { OrderBill } from '../models/OrderBill';
import { ImportBill } from '../models/ImportBill';

const baseUrl = `${environment.apiUrl}/`;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  observe: 'response' as 'body', // to display the full response & as 'body' for type cast
};

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  customer!: Customer;
  constructor(
    private http: HttpClient,
    private storageService: StorageService
  ) {}

  getProductByName(keyword: string): Observable<Product[]> {
    return this.http.get<Product[]>(baseUrl + 'product/getByName/' + keyword);
  }

  checkLogin(credentials: any): Observable<any> {
    return this.http.post(
      baseUrl + 'customer/checkLogin',
      {
        username: credentials.username,
        password: credentials.password,
      },
      httpOptions
    );
  }

  addCartItem(cartitem: CartItem): Observable<any> {
    this.customer = JSON.parse(this.storageService.getCustomer());
    return this.http.post(baseUrl + 'cart-item/' + this.customer.id, cartitem);
  }

  getShoppingCart(customerid: number): Observable<ShoppingCart> {
    return this.http.get<ShoppingCart>(baseUrl + 'shoppingcart/' + customerid);
  }

  getListPayment(): Observable<PaymentMethod[]> {
    return this.http.get<PaymentMethod[]>(baseUrl + 'orderbill/getPayment');
  }

  checkVoucher(code: string): Observable<Voucher> {
    return this.http.get<Voucher>(baseUrl + 'orderbill/checkVoucher/' + code);
  }

  addBill(orderBill: OrderBill): Observable<any> {
    return this.http.post(baseUrl + 'orderbill/addBill', orderBill);
  }

  checkLoginManager(credentials: any): Observable<any> {
    return this.http.post(
      baseUrl + 'manager/checkLogin',
      {
        username: credentials.username,
        password: credentials.password,
      },
      httpOptions
    );
  }

  getListSupplierStat(supportstat: any): Observable<any> {
    return this.http.post(
      baseUrl + 'suplierstat/getListSupplierStat',
      {
        from: supportstat.from,
        to: supportstat.to,
      },
      httpOptions
    );
  }

  getImportHistory(fromdt: string, todt: string, id: number): Observable<any> {
    return this.http.post(baseUrl + 'importbill/getImportHistory/' + id, {
      from: fromdt,
      to: todt,
    });
  }

  getBillDetail(id: number): Observable<ImportBill> {
    return this.http.get<ImportBill>(
      baseUrl + 'importbill/getBillDetail/' + id
    );
  }
}
