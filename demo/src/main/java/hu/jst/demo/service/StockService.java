package hu.jst.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.jst.demo.entity.StockEntity;
import hu.jst.demo.entity.User;
import hu.jst.demo.repository.StockRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Collections;
import java.util.List;

@Service
public class StockService {


    @Autowired
    StockRepository stockRepository;

    //READ
    public List<StockEntity> getStocks() {
        return stockRepository.findAll();
    }

    //READ
    public StockEntity getSpecificStock(String symbol) {
        return stockRepository.findBySymbol(symbol);
    }

    //CREATE
    public StockEntity saveTesla(StockEntity tesla) {
        return stockRepository.save(tesla);
    }

    public StockEntity stockDownloader (String symbol) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key",  "03db22b5camshd34fd82b1dad7a3p13f99cjsn5141407b69d2");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceUrl = "https://alpha-vantage.p.rapidapi.com/query?symbol=" + symbol.toUpperCase() + "&function=GLOBAL_QUOTE";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject obj = new JSONObject(response.getBody().toString());
            obj = obj.getJSONObject("Global Quote");
            StockEntity item = new StockEntity(
                    obj.optString("01. symbol"),
                    obj.optString("02. open"),
                    obj.optString("03. high"),
                    obj.optString("04. low"),
                    obj.optString("05. price"),
                    obj.optString("06. volume"),
                    obj.optString("07. latest trading day"),
                    obj.optString("08. previous close"),
                    obj.optString("09. change"),
                    obj.optString("10. change percent"));


            stockRepository.save(item);
            return item;
        }
        return null;
    }

    public StockEntity saveStock(StockEntity item) {
        if(stockRepository.findBySymbol2(item.getSymbol()).equals(""){
            stockRepository.save(item);
            return item;
        }
        stockRepository.delete(stockRepository.findBySymbol2(item.getSymbol());


    }

    }

