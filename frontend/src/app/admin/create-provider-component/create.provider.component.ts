import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ProviderService } from "../service/provider.service";

@Component({
    selector : 'app-create-provider-component',
    templateUrl : './create.provider.component.html',
    styleUrls : ['./create.provider.component.css']
})

export class CreateProviderComponent {
    
    providerDetails = new FormGroup({
        name : new FormControl('', Validators.required),
        rate : new FormControl('', Validators.required)
    })

    constructor(private providerService : ProviderService) {
    }

    addProvider() : void {
        this.providerService.addProvider(this.providerDetails.value).subscribe();
    }
}