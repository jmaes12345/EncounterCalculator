import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";

@Component({
	selector: 'app-enemy-party',
	templateUrl: './enemy-party.component.html',
	styleUrls: ['./enemy-party.component.scss']
})
export class EnemyPartyComponent implements OnInit {

	columnsToDisplay = ['enemyName', 'enemyXP', 'enemyCount'];
	dataSource = new MatTableDataSource<EnemyPartyEntry>(DEMO_DATA);

	constructor() {
	}

	ngOnInit(): void {
	}
}

const DEMO_DATA: EnemyPartyEntry[] = [
	{currentIndex: 1, enemyName: "Goblin", enemyXP: 50, enemyCount: 6},
	{currentIndex: 2, enemyName: "Hobgoblin", enemyXP: 150, enemyCount: 2},
];

export interface EnemyPartyEntry {
	currentIndex: number,
	enemyName: string,
	enemyXP: number,
	enemyCount: number,
}
