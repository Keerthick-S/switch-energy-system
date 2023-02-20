import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Provider } from "../interface/provider.interface";

@Injectable({
    providedIn : 'root'
})

export class ProviderService {
    BASE_URL : string = 'http://localhost:8090/provider'

    constructor(private http : HttpClient) {
    }

    getProvider() : Observable<Provider[]> {
        return this.http.get<Provider[]>(`${this.BASE_URL}/enabled`);
    }

    switchSmartMeterProvider(smartMeterId : string, providerName : string) : Observable<object> {
        return this.http.put(`${this.BASE_URL}/${smartMeterId}/${providerName}`, null);
    }
}