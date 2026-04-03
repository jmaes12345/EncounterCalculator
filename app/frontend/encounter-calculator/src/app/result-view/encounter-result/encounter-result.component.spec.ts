import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import {EncounterResultComponent} from './encounter-result.component';

describe('EncounterResultComponent', () => {
	let component: EncounterResultComponent;
	let fixture: ComponentFixture<EncounterResultComponent>;

	beforeEach(waitForAsync(() => {
		TestBed.configureTestingModule({
			declarations: [EncounterResultComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(EncounterResultComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
