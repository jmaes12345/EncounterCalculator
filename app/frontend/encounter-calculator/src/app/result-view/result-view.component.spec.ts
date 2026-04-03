import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import {ResultViewComponent} from './result-view.component';

describe('ResultViewComponent', () => {
	let component: ResultViewComponent;
	let fixture: ComponentFixture<ResultViewComponent>;

	beforeEach(waitForAsync(() => {
		TestBed.configureTestingModule({
			declarations: [ResultViewComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(ResultViewComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
