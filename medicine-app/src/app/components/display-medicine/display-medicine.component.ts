import { Component, OnInit } from '@angular/core';
import { Observable} from 'rxjs';
import { map, filter, scan } from 'rxjs/operators';
import { Medicine } from 'src/app/models/medicine';
import { MedicineService } from 'src/app/services/medicine.service';

@Component({
  selector: 'app-display-medicine',
  templateUrl: './display-medicine.component.html',
  styleUrls: ['./display-medicine.component.css']
})
export class DisplayMedicineComponent implements OnInit {
  p: number = 1;

  name = "";
  constructor(private medicineService: MedicineService) { }
  medicines: Observable<Medicine[]>
  ngOnInit(): void {
    this.getMedicines();
  }

  getMedicines(){
    this.medicines = this.medicineService.displayMedicine();
  }

  
}
