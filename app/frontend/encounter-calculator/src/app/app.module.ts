import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ServiceWorkerModule} from '@angular/service-worker';
import {environment} from '../environments/environment';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {PcPartyComponent} from './pc-party/pc-party.component';
import {PcInputFormComponent} from './pc-party/pc-input-form/pc-input-form.component';

import {EnemyPartyComponent} from './enemy-party/enemy-party.component';
import {EnemyInputFormComponent} from './enemy-party/enemy-input-form/enemy-input-form.component';

import {PartyViewComponent} from "./party-view/party-view.component";

import {ResultViewComponent} from './result-view/result-view.component';
import {PcPartyThresholdsComponent} from './result-view/pc-party-thresholds/pc-party-thresholds.component';
import {EncounterResultComponent} from './result-view/encounter-result/encounter-result.component';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";

@NgModule({
	declarations: [
		AppComponent,
		PcPartyComponent,
		PcInputFormComponent,
		EnemyPartyComponent,
		EnemyInputFormComponent,
		PartyViewComponent,
		ResultViewComponent,
		PcPartyThresholdsComponent,
		EncounterResultComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		ServiceWorkerModule.register('ngsw-worker.js', {enabled: environment.production}),
		BrowserAnimationsModule,
		MatGridListModule,
		FormsModule,
		MatFormFieldModule,
		MatInputModule,
		MatButtonModule,
		ReactiveFormsModule,
		// MatSliderModule,
		MatTableModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule {
}
