import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, ValidatorFn, FormControl, AbstractControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { CustomerDetails } from '../../customerDetails';



@Component({
  selector: 'application-details',
  templateUrl: './application-details.component.html',
  styleUrls: ['./application-details.component.css'],
})


export class ApplicationDetailsComponent implements OnInit {

 
  salary: number;

  userDetail: CustomerDetails;

  applicationDetailsForm: FormGroup;

 
  constructor(private fb: FormBuilder, private router: Router, private service: UserService) {
    if (!sessionStorage.getItem('username')){
      this.router.navigate(['/userLogin']);
    }

    
    this.service.getUserDetails(sessionStorage.getItem('username')).subscribe(data=>{

      this.userDetail = data;
      alert(this.userDetail.salary);
    });

  }


  ngOnInit(): void {

    this.applicationDetailsForm = this.fb.group({
      property_location: ['', Validators.required],
      property_name: ['', Validators.required],
      estimated_property_amt: [
        '',
        [Validators.required, Validators.pattern('^[0-9]*$')],
      ],
      loan_amount: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      interest_rate: [
        '',
        [Validators.required, Validators.pattern('^[0-9]*$')],
      ],
      tenure: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      LOA: [],
      NOC: [],
      agreement_to_sale: [],
    });
  }

  addApplicationDetails(): void {}
}
