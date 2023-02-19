export interface SmartMeter {
    id : string;
    provider : string;
    reading : number
}

export interface SmartMeterDetails {
    reading : number;
    amount : number;
    smartMeterId : string
}