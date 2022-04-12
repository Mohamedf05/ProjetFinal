import { OrganisateurService } from './../../services/organisateur.service';
import { debounceTime, map, Observable } from 'rxjs';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-inscription-organisateur',
  templateUrl: './inscription-organisateur.component.html',
  styleUrls: ['./inscription-organisateur.component.css'],
})
export class InscriptionOrganisateurComponent implements OnInit {
  form: FormGroup;

  constructor(
    private organisateurService: OrganisateurService,
    private router: Router
  ) {
    this.form = new FormGroup({
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      raisonSoc: new FormControl('', Validators.required),

      emailPasswordGroup: new FormGroup(
        {
          email: new FormControl(
            '',
            [Validators.required, Validators.email],
            this.checkEmail()
          ),
          passwordGroup: new FormGroup(
            {
              password: new FormControl('', [
                Validators.required,
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{4,}$/
                ),
              ]),
              confirm: new FormControl('', Validators.required),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.mailAndPasswordNotEquals
      ),
      numero: new FormControl('', Validators.required),
      rue: new FormControl('', Validators.required),
      codePostal: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
    });
  }

  checkEmail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.organisateurService.findByEmail(control.value).pipe(
        debounceTime(1000),
        map((result) => {
          return result ? { emailExist: true } : null;
        })
      );
    };
  }

  mailAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('email')?.invalid || group.get('passwordGroup')?.invalid) {
      return null;
    }
    return group.get('email')?.value ==
      group.get('passwordGroup.password')?.value
      ? { mailAndPasswordEquals: true }
      : null;
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.errors) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEquals: true };
  }

  ngOnInit(): void {}

  submit() {
    let compte = {
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      mail: this.form.get('emailPasswordGroup.email')?.value,
      raisonSoc: this.form.get('raisonSoc')?.value,
      password: this.form.get('emailPasswordGroup.passwordGroup.password')
        ?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        voie: this.form.get('rue')?.value,
        cp: this.form.get('codePostal')?.value,
        ville: this.form.get('ville')?.value,
      },
    };
    this.organisateurService.InscriptionOrganisateur(compte).subscribe((ok) => {
      this.router.navigateByUrl('/login');
    });
  }
}
