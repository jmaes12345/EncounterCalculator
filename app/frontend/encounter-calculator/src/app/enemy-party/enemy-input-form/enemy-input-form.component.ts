import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-enemy-input-form',
	templateUrl: './enemy-input-form.component.html',
	styleUrls: ['./enemy-input-form.component.scss']
})
export class EnemyInputFormComponent implements OnInit {
	enemyGroup: UntypedFormGroup;
	enemyNameControl = new UntypedFormControl(1, [Validators.required, Validators.maxLength(30)]);
	xpControl = new UntypedFormControl(1, [Validators.min(1), Validators.required]);
	enemyOfThisTypeCountControl = new UntypedFormControl(1, [Validators.min(1), Validators.required]);

	constructor(fb: UntypedFormBuilder) {
		this.enemyGroup = fb.group({
			enemyNameControl: this.enemyNameControl,
			xpControl: this.xpControl,
			enemyOfThisTypeCountControl: this.enemyOfThisTypeCountControl,
		});
	}

	ngOnInit(): void {
	}

	addEnemies() {
		// TODO: Use EventEmitter with form value
		console.warn(this.enemyGroup.value);
	}

}
