import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import {PcInputFormComponent} from './pc-input-form.component';

describe('PcInputFormComponent', () => {
	let component: PcInputFormComponent;
	let fixture: ComponentFixture<PcInputFormComponent>;

	beforeEach(waitForAsync(() => {
		TestBed.configureTestingModule({
			declarations: [PcInputFormComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(PcInputFormComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
