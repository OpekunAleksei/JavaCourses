import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EquipmentRentalInterceptor implements HttpInterceptor {

    constructor(private cookieService: CookieService) { }

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let cloneReq = req;

        if (this.cookieService.get('token') !== undefined) {
            cloneReq = req.clone({
                setHeaders: { Authorization: this.cookieService.get('token') },
            });
        }
        return next.handle(cloneReq);
    }
}
