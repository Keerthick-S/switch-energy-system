import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { provider } from "../interface/provider";
import { ProviderDetails } from "../interface/providerDetails";

@Injectable({
    providedIn: 'root'
})

export class ProviderService {

    BASE_URL : String = 'http://localhost:8090/provider'

    constructor(private http: HttpClient) {
    }

    getAllProviders() : Observable<provider[]> {
        return this.http.get<provider[]>(`${this.BASE_URL}`);
    }

    disableProvider(providerName : string) : Observable<string> {
        return this.http.put<string>(`${this.BASE_URL}/disable/${providerName}`, null);
    }

    enableProvider(providerName: string) : Observable<string> {
        return this.http.put<string>(`${this.BASE_URL}/enable/${providerName}`, null);
    }

    addProvider(providerDetails : Object) : Observable<Object> {
        return this.http.post<ProviderDetails>(`${this.BASE_URL}`, providerDetails);
    }
}