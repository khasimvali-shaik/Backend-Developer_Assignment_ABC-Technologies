import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
res:String;
success:String;
fail:String;
  constructor(private router: Router) {
    this.res = this.router.getCurrentNavigation().extras.state.result;
    if((this.res).includes("order id")){
      this.success = this.res;
    }
    else{
      this.fail = this.res;
    }
  }

  ngOnInit(): void {
  }

}
