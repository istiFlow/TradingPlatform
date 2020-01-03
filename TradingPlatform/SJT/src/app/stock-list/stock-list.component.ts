import { Component, OnInit } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {

  stocks: Array<any>;

  constructor(private stockService: StockService) { }

  ngOnInit() {
    this.stockService.getAll().subscribe(data => {
      this.stocks = data;
    });
  }

}
