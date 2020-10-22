import {Component, OnInit} from '@angular/core';
import {PCPartyEntry} from "../../pc-party/pc-party.component";

@Component({
	selector: 'app-encounter-result',
	templateUrl: './encounter-result.component.html',
	styleUrls: ['./encounter-result.component.scss']
})
export class EncounterResultComponent implements OnInit {
	encounterXpTotal: number;
	encounterXpTotalPerPC: number;

	constructor() {
		//TODO
	}

	private static getEncounterXpTotal(): number {
		//TODO
		return 500;
	}

	ngOnInit() {
		this.onChanges();
	}

	onChanges(): void {
		this.encounterXpTotal = EncounterResultComponent.getEncounterXpTotal();
		this.encounterXpTotalPerPC = (this.encounterXpTotal / this.getPCPartySize());
	}

	private getPCPartySize(): number {
		let totalPCCount = 0;

		// TODO
		for (let i = 0; i < DEMO_DATA_2.length; i++) {
			totalPCCount += DEMO_DATA_2[i].pcCount
		}

		return totalPCCount;
	}

}

//TODO remove
const DEMO_DATA_2: PCPartyEntry[] = [
	{currentIndex: 1, pcLevel: 4, pcCount: 3},
	{currentIndex: 2, pcLevel: 3, pcCount: 2},
];
