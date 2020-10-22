import {Component, OnInit} from '@angular/core';
import {DifficultyRank} from "../../model/difficulty-rank";
import {Difficulty} from "../../model/difficulty";


@Component({
	selector: 'app-pc-party-thresholds',
	templateUrl: './pc-party-thresholds.component.html',
	styleUrls: ['./pc-party-thresholds.component.scss']
})
export class PcPartyThresholdsComponent implements OnInit {
	difficultyRanks: DifficultyRank[];

	constructor() {
		this.difficultyRanks = this.createDefaultDifficulty();
	}

	ngOnInit(): void {
	}

	// TODO only to provide demo values, remove when all wiring is in place
	createDefaultDifficulty(): Array<DifficultyRank> {
		let difficultyArray = new Array<DifficultyRank>();
		for (let difficulty in Difficulty) {
			let rank = new DifficultyRank();
			rank.rank = Difficulty[difficulty];
			rank.xp = 5;
			difficultyArray.push(rank);
		}
		return difficultyArray;
	}

	updateDifficulty(): void {
		// get values
		for (let rank in this.difficultyRanks.values()) {
			//update each value
			// rank.xp = 0;
		}
		//call refresh
	}
}
