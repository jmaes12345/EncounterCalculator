import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EnemyInputFormComponent} from './enemy-input-form.component';

describe('EnemyInputFormComponent', () => {
	let component: EnemyInputFormComponent;
	let fixture: ComponentFixture<EnemyInputFormComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [EnemyInputFormComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(EnemyInputFormComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
