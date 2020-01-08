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

    private String[] stockList = {"PLUG", "FCEL", "AAPL", "CTIB", "CSCO", "MSFT", "SIRI", "INTEL"
    , "CMSCA", "ARQL", "LIFE", "MRLV", "BGCP", "MYL", "AMAT", "QCOM", "GILD", "BBBY", "HBAN", "NVDA",
    "EBAY", "ACOR", "NFLX", "GPOR", "SPPI", "SBUX", "AGNC", "ATVI", "TEAM", "OSTK", "GOOGL", "TSLA", "AMZN"};

    @Autowired
    StockService stockService;

    @Scheduled(fixedRate = 600000000)
    public void downloadStocks() throws JsonProcessingException {
        for (int i = 0; i < stockList.length; i++) {
            stockService.stockDownloader(stockList[i]);
        }
    }
}
