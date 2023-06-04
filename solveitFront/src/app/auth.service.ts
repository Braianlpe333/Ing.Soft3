import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;

  login() {
    // Lógica para autenticar al usuario
    this.isLoggedIn = true;
  }

  logout() {
    // Lógica para cerrar sesión
    this.isLoggedIn = false;
  }
}
