import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import {PcPartyComponent} from './pc-party.component';

describe('PcPartyComponent', () => {
	let component: PcPartyComponent;
	let fixture: ComponentFixture<PcPartyComponent>;

	beforeEach(waitForAsync(() => {
		TestBed.configureTestingModule({
			declarations: [PcPartyComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(PcPartyComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
