import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PcPartyComponent} from './pc-party.component';

describe('PcPartyComponent', () => {
	let component: PcPartyComponent;
	let fixture: ComponentFixture<PcPartyComponent>;

	beforeEach(async(() => {
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
