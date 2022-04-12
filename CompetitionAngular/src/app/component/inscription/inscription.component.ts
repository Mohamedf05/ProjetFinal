import { debounceTime, map, Observable } from 'rxjs';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  inscriptionForm: FormGroup;

  constructor(private router: Router) {
    this.inscriptionForm = new FormGroup({
      typeCompte: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {}

  submit() {
    this.router.navigateByUrl(
      '/inscription/' + this.inscriptionForm.get('typeCompte')?.value
    );
  }
}
