import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector : 'app-toolbar-component',
    templateUrl : './toolbar.component.html',
    styleUrls : ['./toolbar.component.css']
})

export class ToolbarComponent {

    constructor(private router : Router){
    }

    navigateSmartmeterPage(): void {
        this.router.navigateByUrl('admin/smartmeter');
    }

    navigateProviderPage() : void {
        this.router.navigateByUrl('admin/provider');
    }

    navigateAddProvider() : void {
        this.router.navigateByUrl('admin/add-provider')
    }
}