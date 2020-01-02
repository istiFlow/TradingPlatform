package hu.jst.demo.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.jst.demo.service.StockService;
import hu.jst.demo.stocksymbols.StockSymbols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledDownload {

    @Autowired
    StockService stockService;

    @Scheduled(fixedRate = 600000)
    public void downloadStocks() throws JsonProcessingException {
        stockService.stockDownloader(StockSymbols.TSLA.toString());
        stockService.stockDownloader(StockSymbols.GOOGL.toString());
        stockService.stockDownloader(StockSymbols.AMZN.toString());
        stockService.stockDownloader(StockSymbols.AAPL.toString());
        stockService.stockDownloader(StockSymbols.MSFT.toString());
    }
}
