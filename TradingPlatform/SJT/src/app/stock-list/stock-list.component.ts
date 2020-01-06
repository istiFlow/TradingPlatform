import { Component, OnInit } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';
import { Stock } from '../stock';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})

export class StockListComponent implements OnInit {
  stocks: Stock[];
  stocks2: Array<any>;
  symbol : string;
  successMessage: string;
  isSearched = false;
  displayedColumns: string[] = ['id', 'symbol', 'open', 'high', 'low', 'price', 'volume', 'latestTradingDay', 'previousClose', 'change', 'changePercent'];

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

  handleDelete() {
    let resp = this.stockService.deleteSpecificStock(this.symbol)
    .subscribe(() => this.successMessage = "Bye",
    (err) => console.log(err))
  }

}
