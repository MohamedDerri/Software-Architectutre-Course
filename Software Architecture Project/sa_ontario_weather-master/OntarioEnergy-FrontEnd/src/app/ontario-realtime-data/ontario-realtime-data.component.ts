import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { OntarioRealtimeService } from '../ontario-realtime.service';

export class OntarioWeatherData {
    date!: String;
    timeOfReading: String;
    powerGenerated: String;
    ontarioDemand: String;
    totalCo2e: String;
    co2eIntensity: String;
    nuclearPercentage: String;
    nuclearOutput: String;
    hydroPercentage: String;
    hydroOutput: String;
    gasPercentage: String;
    gasOutput: String;
    windPercentage: String;
    windOutput: String;
    biofuelPercentage: String;
    biofuelOutput: String;
    solarPercentage: String;
    solarOutput: String;
    imports: String;
    exports: String;
    netImportExports: String;
  constructor() {
    this.timeOfReading = '';
    this.powerGenerated = '';
    this.ontarioDemand = '';
    this.totalCo2e='';
    this.co2eIntensity='';
    this.nuclearPercentage='';
    this.nuclearOutput='';
    this.hydroPercentage='';
    this.hydroOutput='';
    this.gasPercentage='';
    this.gasOutput='';
    this.windPercentage='';
    this.windOutput='';
    this.biofuelPercentage='';
    this.biofuelOutput='';
    this.solarPercentage='';
    this.solarOutput='';
    this.imports='';
    this.exports='';
    this.netImportExports='';
  }
}
export class OntarioRealtimeData {
    data: OntarioWeatherData[] = new Array();
    constructor() {
      
    }
}

@Component({
  selector: 'app-ontario-realtime-data',
  templateUrl: './ontario-realtime-data.component.html',
  styleUrls: ['./ontario-realtime-data.component.css']
})
export class OntarioRealtimeDataComponent implements OnInit {

  data: OntarioRealtimeData = new OntarioRealtimeData();
  constructor(private _ontarioRealtimeService: OntarioRealtimeService){}

  ngOnInit(): void {
    setInterval(() => {
      this._ontarioRealtimeService.getData().subscribe({
        next: (data) => {
          this.data = data;
          console.log(this.data.data[0]);
          
        },
        error: (err) => {
          console.log("Got error from ontarial realtime data:"  + err);
        }
      })
    }, 2000);
   
  }

}
