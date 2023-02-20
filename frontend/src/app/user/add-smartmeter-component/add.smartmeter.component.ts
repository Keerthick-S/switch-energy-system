import { Component, Inject, OnInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Provider } from "../interface/provider.interface";
import { ProviderService } from "../service/provider.service";
import { ToolbarComponent } from "../toolbar-component/toolbar.component";

@Component({
    selector : 'add-smartmeter-component',
    templateUrl : './add.smartmeter.component.html',
    styleUrls : ['./add.smartmeter.component.css']
})

export class AddSmartmeterComponent implements OnInit {

    selected : Provider = {
        name: "",
        rate: 0
    };

    providers : Provider[] = [];
    
    constructor(private providerService : ProviderService,public dialogRef: MatDialogRef<ToolbarComponent>) {}

    ngOnInit(): void {
        this.providerService.getProvider().subscribe({
            next : (res) => {
                this.providers = res;
            }
        })        
    }
    
    onNoClick(): void {
    this.dialogRef.close();
    }
}