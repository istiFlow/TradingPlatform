package hu.jst.demo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import hu.jst.demo.entity.StockEntity;
import hu.jst.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class StockController {

    @Autowired
    StockService stockService;

    //Get every stocks from the database
    @GetMapping ("stocks")
    public String stocks() {
        return stockService.getStocks().toString();
    }

    //Get specific stock by name
    @GetMapping ("/{name}")
    public StockEntity searchStocksByName(@PathVariable(value = "name") String name) {
        return stockService.getSpecificStock(name);
    }

    //Get specific stock by symbol
    //Symbols for download (TSLA - Tesla, MSFT - Microsoft, AAPL - Apple, GOOGL - Google, AMZN - Amazon)
    @GetMapping ("download/{symbol}")
    public StockEntity downloadStockData(@PathVariable String symbol) throws JsonProcessingException {
        StockEntity item = stockService.stockDownloader(symbol);
        return item;
    }

    @PostMapping(value = "post", consumes="application/json")
    public StockEntity createStock(@RequestBody StockEntity stock) {
        return stockService.saveStock(stock);
    }

    @DeleteMapping(value = "stock/{id}" )
    public void deleteStock(@PathVariable long id) {
        stockService.deleteStock(id);
    }
}
