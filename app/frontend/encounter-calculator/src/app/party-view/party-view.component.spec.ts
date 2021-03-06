import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PartyViewComponent} from './party-view.component';

describe('PartyVIewComponent', () => {
	let component: PartyViewComponent;
	let fixture: ComponentFixture<PartyViewComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [PartyViewComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(PartyViewComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
