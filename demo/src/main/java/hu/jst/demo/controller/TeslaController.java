package hu.jst.demo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import hu.jst.demo.entity.TeslaQuoteEntity;
import hu.jst.demo.entity.User;
import hu.jst.demo.service.TeslaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/stock")
public class TeslaController {

    @Autowired
    TeslaService teslaService;

    //Működik
    @GetMapping("/data")
    public ResponseEntity<String> tesla () throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key",  "03db22b5camshd34fd82b1dad7a3p13f99cjsn5141407b69d2");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceUrl = "https://alpha-vantage.p.rapidapi.com/query?symbol=TSLA&function=GLOBAL_QUOTE";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            //System.out.println(response.toString());
            JSONObject obj = new JSONObject(response.getBody().toString());
            obj = obj.getJSONObject("Global Quote");
            TeslaQuoteEntity item = new TeslaQuoteEntity(
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
            teslaService.saveTesla(item);
            System.out.println(item);
            return response;
        }
        return null;
    }
    @GetMapping("/msft")
    public ResponseEntity<String> msft () throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key",  "03db22b5camshd34fd82b1dad7a3p13f99cjsn5141407b69d2");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceUrl = "https://alpha-vantage.p.rapidapi.com/query?symbol=MSFT&function=GLOBAL_QUOTE";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            //System.out.println(response.toString());
            JSONObject obj = new JSONObject(response.getBody().toString());
            obj = obj.getJSONObject("Global Quote");
            TeslaQuoteEntity item = new TeslaQuoteEntity(
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
            teslaService.saveTesla(item);
            System.out.println(item);
            return response;
        }
        return null;
    }

    @PostMapping(value = "/make", consumes="application/json")
    public TeslaQuoteEntity createTesla(@RequestBody TeslaQuoteEntity tesla) {
        return teslaService.saveTesla(tesla);
    }
}
