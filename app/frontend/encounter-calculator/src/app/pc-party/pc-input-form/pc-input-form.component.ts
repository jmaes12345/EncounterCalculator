import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-pc-input-form',
	templateUrl: './pc-input-form.component.html',
	styleUrls: ['./pc-input-form.component.scss']
})
export class PcInputFormComponent implements OnInit {
	pcGroup: FormGroup;
	pcLevelControl = new FormControl(1, [Validators.min(1), Validators.max(20), Validators.required]);
	pcCountControl = new FormControl(1, [Validators.min(1), Validators.required]);

	constructor(fb: FormBuilder) {
		this.pcGroup = fb.group({
			pcLevelControl: this.pcLevelControl,
			pcCountControl: this.pcCountControl,
		});
	}

	ngOnInit(): void {
	}

	addPC() {
		// TODO: Use EventEmitter with form value
		console.warn(this.pcGroup.value);
	}
}
