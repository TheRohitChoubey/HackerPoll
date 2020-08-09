import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  _baseUrl:any
  userData: any
  email : string
  emailForm:FormGroup
  constructor(private userService: UserService,private route: ActivatedRoute, private router: Router) { }
  ngOnInit() {
    this.emailForm = new FormGroup({
      email: new FormControl("",Validators.compose([
        Validators.required,Validators.email
      ])),
      password : new FormControl("",Validators.compose([
        Validators.required
      ])),
  })
  
  this.email = localStorage.getItem("email");
  if(this.email != null){
    this.router.navigate(['/user']);
  }
}

  submit() {
    let email = this.emailForm.value.email;
    let password = this.emailForm.value.password;
    console.log(email);
    
    
   this.userService.login(email,password).subscribe({
    next: (data : any) => {
      localStorage.setItem("email",data.email);
      this.router.navigate(['/poll']);
    },
    error: error => console.error('There was an error!', error)
    })
  }

}
