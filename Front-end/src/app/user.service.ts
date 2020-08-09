import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  constructor(private http:HttpClient) {
   }  
  public baseUrl = `http://localhost:8092`;

  public getIPAddress(){  
    return this.http.get("http://api.ipify.org/?format=json");  
  }
  
  public login(email, password){ 
    const headers = { "content-Type": "application/json", "Accept": 'application/json'};
    const body = { email :email, password : password };
    return  this.http.post(this.baseUrl+'/login', body, { headers });  
  }

  public registerUpdate(resgiterCandidate){ 
    const headers = { "content-Type": "application/json", "Accept": 'application/json'};
    const body = resgiterCandidate;
    console.log(body);
    return  this.http.post(this.baseUrl+'/registerupdate', body, { headers });  
  }

  public candidateDetail(candidateEmail){
    return  this.http.get(this.baseUrl+'/candidateDetail/'+candidateEmail);  
  }

  public getAllCandidates(){
    return  this.http.get(this.baseUrl+'/allCandidates');  
  }

  public vote(votingData){ 
    const headers = { "content-Type": "application/json", "Accept": 'application/json'};
    const body = votingData;
    console.log(body);
    return  this.http.post(this.baseUrl+'/vote', body, { headers });  
  }
}
