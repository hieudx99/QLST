import { Injectable } from '@angular/core';
import { Customer } from '../models/Customer';
import { Product } from '../models/Product';
import { Staff } from '../models/Staff';
import { SupplierStat } from '../models/SupplierStat';

const customer = 'customer';
const staff = 'staff';
const keyword = 'keyword';
const product = 'product';
const fromdate = 'from';
const todate = 'to';
const listSupplierStat = 'listSupplierStat';

@Injectable({
  providedIn: 'root',
})
export class StorageService {
  constructor() {}

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveCustomer(c: Customer): void {
    window.sessionStorage.removeItem(customer);
    window.sessionStorage.setItem(customer, JSON.stringify(c));
  }

  public getCustomer(): string {
    console.log(sessionStorage.getItem(customer));
    return sessionStorage.getItem(customer) || '';
  }

  public saveKeyword(kw: string): void {
    console.log(kw);
    window.sessionStorage.removeItem(keyword);
    window.sessionStorage.setItem(keyword, kw);
  }

  public getKeyword(): string {
    return sessionStorage.getItem(keyword) || '';
  }

  public saveProduct(p: Product): void {
    window.sessionStorage.removeItem(product);
    window.sessionStorage.setItem(product, JSON.stringify(p));
  }

  public getProduct(): string {
    return sessionStorage.getItem(product) || '';
  }

  public saveStaff(s: Staff): void {
    window.sessionStorage.removeItem(staff);
    window.sessionStorage.setItem(staff, JSON.stringify(s));
  }

  public getStaff(): string {
    console.log(sessionStorage.getItem(staff));
    return sessionStorage.getItem(staff) || '';
  }

  public saveListSupplierStat(list: SupplierStat[]): void {
    window.sessionStorage.removeItem(listSupplierStat);
    window.sessionStorage.setItem(listSupplierStat, JSON.stringify(list));
  }
  public getListSupplierStat(): string {
    console.log(sessionStorage.getItem(listSupplierStat));
    return sessionStorage.getItem(listSupplierStat) || '';
  }

  public saveFrom(from: string): void {
    window.sessionStorage.removeItem(fromdate);
    window.sessionStorage.setItem(fromdate, from);
  }

  public getFrom(): string {
    return sessionStorage.getItem(fromdate) || '';
  }
  public saveTo(to: string): void {
    window.sessionStorage.removeItem(todate);
    window.sessionStorage.setItem(todate, to);
  }

  public getTo(): string {
    return sessionStorage.getItem(todate) || '';
  }
}
