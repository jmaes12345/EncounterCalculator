import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";

@Component({
	selector: 'app-pc-party',
	templateUrl: './pc-party.component.html',
	styleUrls: ['./pc-party.component.scss']
})
export class PcPartyComponent implements OnInit {
	columnsToDisplay = ['pcLevel', 'pcCount'];
	dataSource = new MatTableDataSource<PCPartyEntry>(DEMO_DATA);

	constructor() {
	}

	ngOnInit(): void {
	}
}

const DEMO_DATA: PCPartyEntry[] = [
	{currentIndex: 1, pcLevel: 4, pcCount: 3},
	{currentIndex: 2, pcLevel: 3, pcCount: 2},
];

export interface PCPartyEntry {
	currentIndex: number,
	pcLevel: number,
	pcCount: number
}
