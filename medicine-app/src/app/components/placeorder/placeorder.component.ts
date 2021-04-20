import { formatCurrency } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { MedicineService } from 'src/app/services/medicine.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {
  
  constructor(private medicineService: MedicineService, private router: Router) { }

  ngOnInit(): void {
  }
  process(data:NgForm){
    this.medicineService.orderMedicine(data.value).subscribe( res =>{
     this.router.navigate(['result'], { state: {result: res } });
     
    });
    data.reset();
  }


}
