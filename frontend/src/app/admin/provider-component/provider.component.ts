import { getLocaleMonthNames } from "@angular/common";
import { Component } from "@angular/core";
import Swal from "sweetalert2";
import { provider } from "../interface/provider";
import { ProviderService } from "../service/provider.service";

@Component({
    selector : 'app-provider-component',
    templateUrl : './provider.component.html',
    styleUrls : ['./provider.component.css'] 
})

export class ProviderComponent {

    providers : provider[] = [];

    constructor(private providerService : ProviderService) {
    }

    ngOnInit(): void {
        this.providerService.getAllProviders().subscribe(res => {
            this.providers = res;
        })
    }
    
    disableProvider(providerName : string , index : number) : void {
        Swal.fire({
            title: `Are you sure, You want to disable ${providerName}?`,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#000850',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Disable'
        }).then((result) => {
            if (result.isConfirmed) {
                this.providerService.disableProvider(providerName).subscribe();
                this.providers[index].enable = false;
                Swal.fire(
                'Disabled',
                'Provider has been disabled successfully',
                'success'
              )
            }
          })
    }
    
    enableProvider(providerName : string, index : number) : void {
        Swal.fire({
            title: `Are you sure, You want to enable ${providerName}?`,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#000850',
            cancelButtonColor: 'rgb(79, 90, 114)',
            confirmButtonText: 'Enable'
        }).then((result) => {
            if (result.isConfirmed) {
                this.providerService.enableProvider(providerName).subscribe();
                this.providers[index].enable = true;
                Swal.fire(
                'Enabled',
                'Provider has been enabled successfully',
                'success'
              )
            }
        })
    }
}