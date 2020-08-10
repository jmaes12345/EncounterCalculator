import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EncounterResultComponent} from './encounter-result.component';

describe('EncounterResultComponent', () => {
	let component: EncounterResultComponent;
	let fixture: ComponentFixture<EncounterResultComponent>;

	beforeEach(async(() => {
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
