import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EnemyPartyComponent} from './enemy-party.component';

describe('EnemyPartyComponent', () => {
	let component: EnemyPartyComponent;
	let fixture: ComponentFixture<EnemyPartyComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [EnemyPartyComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(EnemyPartyComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
