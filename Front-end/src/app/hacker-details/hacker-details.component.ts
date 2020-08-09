import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material';
import { UserService } from '../user.service';

@Component({
  selector: 'app-hacker-details',
  templateUrl: './hacker-details.component.html',
  styleUrls: ['./hacker-details.component.css']
})
export class HackerDetailsComponent implements OnInit {

  ELEMENT_DATA: Candidate[] = [];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  displayedColumns: string[] = ['username','email',"votes"];
  email : string 

  constructor(private route: ActivatedRoute, private router: Router, private userService : UserService) {
  }

  ngOnInit() {
    
    this.userService.getAllCandidates().subscribe((res:any)=>{
      console.log(res);
      this.ELEMENT_DATA = res;
      this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
    });

    let localEmail = localStorage.getItem("email");
    if(this.email == null || typeof this.email == undefined){
      this.email = localEmail;
    }
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getRecord(row : Candidate){
    console.log(row);
    this.router.navigate(['/user'],{ queryParams: { email: row.email }});
  }

  logOut(){
    alert("User Logged out");
    localStorage.clear();
  }
}

export interface Candidate{
  username: string;
  email: string;
  location : string;
  algorithms: string;
  contest : string;
  cpp: string;
  datastructure: string;
  java: string;
  python: string;
  votes: number;
}