import { Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';

const TOKEN_KEY = 'auth_token';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  token_decoded: any = {};

  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY) || "";
  }

  public getDecodedAcessToken(): string {
    return (jwtDecode(sessionStorage.getItem(TOKEN_KEY)!.replace("Bearer ","")));
  }

  public getSubject(): any {
    
    this.token_decoded = this.getDecodedAcessToken();
    let subject = this.token_decoded.sub;
    return subject;
  }

  public getAuthorities(): any {
    this.token_decoded = this.getDecodedAcessToken();
    let authorities = this.token_decoded.authorities;
    return authorities;
  }
}
