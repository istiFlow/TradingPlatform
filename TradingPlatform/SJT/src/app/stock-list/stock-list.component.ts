import { Component, OnInit } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {

  stocks: Array<any>;
  stocks2: Array<any>;
  symbol : string;
  isSearched = false;

  constructor(private stockService: StockService) { }

  ngOnInit() {
    this.stockService.getAll().subscribe(data => {
      this.stocks = data;
    });
  }

  handleSearch() {
    this.stockService.getSpecificStock(this.symbol)
    .subscribe(data => {
      this.stocks2 = data;
    })
    this.isSearched = true;
  }



}
