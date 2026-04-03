import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import {PcPartyThresholdsComponent} from './pc-party-thresholds.component';

describe('PcPartyThresholdsComponent', () => {
	let component: PcPartyThresholdsComponent;
	let fixture: ComponentFixture<PcPartyThresholdsComponent>;

	beforeEach(waitForAsync(() => {
		TestBed.configureTestingModule({
			declarations: [PcPartyThresholdsComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(PcPartyThresholdsComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
