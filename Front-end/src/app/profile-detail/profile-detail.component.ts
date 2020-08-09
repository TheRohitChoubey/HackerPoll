import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit {
  adminEmail : string
  candidateEmail : string 
  candidateDetail ?: Candidate| any = null;
  ipAddress:string
  registerForm: FormGroup
  votingData : any
  constructor(private route: ActivatedRoute, private userService : UserService, private router: Router) {
    
   }
  

  ngOnInit() {
    
    this.registerForm = new FormGroup({
      email: new FormControl("",Validators.compose([
        Validators.required,Validators.email
      ])),
      username: new FormControl("",Validators.compose([
        Validators.required,Validators.minLength(3),Validators.maxLength(30)
      ])),
      location: new FormControl("",Validators.compose([
        Validators.required,
      ])),
      contest: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(50000), Validators.pattern(/^\d+$/)
      ])),
      dataStructureRating: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(5), Validators.pattern(/^\d+$/)
      ])),
      pythonRating: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(5), Validators.pattern(/^\d+$/)
      ])),
      cppRating: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(5), Validators.pattern(/^\d+$/)
      ])),
      javaRating: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(5), Validators.pattern(/^\d+$/)
      ])),
      algorithmsRating: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(5), Validators.pattern(/^\d+$/)
      ]))
      
    })
    this.getIP();
    let localEmail = localStorage.getItem("email");
    if(this.adminEmail == null || typeof this.adminEmail == undefined){
      this.adminEmail = localEmail;
    }
    this.route.queryParams.subscribe(params => {
      this.candidateEmail = params['email'];
    });
    
    if(this.candidateEmail){
      this.userService.candidateDetail(this.candidateEmail).subscribe((res:any)=>{
          this.candidateDetail = res;
          console.log(this.candidateDetail);
          this.registerForm.controls['email'].setValue(this.candidateDetail.email);
          this.registerForm.controls['username'].setValue(this.candidateDetail.username);
          this.registerForm.controls['location'].setValue(this.candidateDetail.location);
          this.registerForm.controls['contest'].setValue(this.candidateDetail.contest);
          this.registerForm.controls['dataStructureRating'].setValue(this.candidateDetail.datastructure);
          this.registerForm.controls['pythonRating'].setValue(this.candidateDetail.python);
          this.registerForm.controls['cppRating'].setValue(this.candidateDetail.cpp);
          this.registerForm.controls['javaRating'].setValue(this.candidateDetail.java);
          this.registerForm.controls['algorithmsRating'].setValue(this.candidateDetail.algorithms);

      });  
    }
  }

  getIP(){  
    this.userService.getIPAddress().subscribe((res:any)=>{  
      this.ipAddress=res.ip;  
    });  
  }
  
  voteNow(){
      console.log(this.candidateEmail);
      this.votingData = {
        ip : this.ipAddress,
        email : this.candidateEmail
      }

      this.userService.vote(this.votingData).subscribe({
        next: (data : any) => {
          console.log("My data",data);
          if(data.email != "Not Found"){
            alert("Thanks For Voting");
          }
          else{
            alert("Either you have already Voted or The Candidate doesn't exist");
          }
            this.router.navigate(['/poll']);
        },
        error: error => console.error('There was an error!', error)
        })
  }

  submit() {
    let resgiterCandidate = {
      username: this.registerForm.value.username,
      email: this.registerForm.value.email,
      password : '',
      location : this.registerForm.value.location,
      contest : this.registerForm.value.contest,
      datastructure: this.registerForm.value.dataStructureRating,
      python: this.registerForm.value.pythonRating,
      cpp: this.registerForm.value.cppRating,
      java: this.registerForm.value.javaRating,
      algorithms: this.registerForm.value.algorithmsRating,
      votes: 0
    }
    this.userService.registerUpdate(resgiterCandidate).subscribe({
      next: (data : any) => {
        this.router.navigate(['/poll']);
      },
      error: error => console.error('There was an error!', error)
      })

  }

  logOut(){
    alert("User Logged out");
    localStorage.clear();
  }

}

export interface Candidate{
  username ?: string| any;
  email ?: string| any;
  location ?: string| any;
  algorithms ?: string| any;
  contest ?: string| any;
  cpp ?: string| any;
  datastructure ?: string| any;
  java ?: string| any;
  python ?: string| any;
  votes ?: number| any;
}