package hu.jst.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="stocks")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Column(name = "symbol")
    private String symbol;

    @Column(name = "open_")
    private Double open;

    @Column(name = "high")
    private Double high;


    @Column(name = "low")
    private Double low;

    @Column(name = "price")
    private Double price;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "latestTradingDay")
    private LocalDate latestTradingDay;

    @Column(name = "previousClose")
    private Double previousClose;

    @Column(name = "change_")
    private Double change;


    @Column(name = "changePercent")
    private String changePercent;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = Double.parseDouble(open);
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = Double.parseDouble(high);
    }

    public Double getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = Double.parseDouble(low);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = Integer.parseInt(volume);
    }

    public LocalDate getLatestTradingDay() {
        return latestTradingDay;
    }

    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = LocalDate.parse(latestTradingDay);
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = Double.parseDouble(previousClose);
    }

    public Double getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = Double.parseDouble(change);
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }


    private StockEntity() {}

    public StockEntity(String symbol, Double open, Double high, Double low, Double price, Integer volume, LocalDate latestTradingDay, Double previousClose, Double change, String changePercent) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.price = price;
        this.volume = volume;
        this.latestTradingDay = latestTradingDay;
        this.previousClose = previousClose;
        this.change = change;
        this.changePercent = changePercent;
    }

    public StockEntity(String symbol, String open, String high, String low, String price, String volume, String latestTradingDay, String previousClose, String change, String changePercent) {
        this.symbol = symbol;
        setOpen(open);
        setHigh(high);
        setLow(low);
        setPrice(price);
        setVolume(volume);
        setLatestTradingDay(latestTradingDay);
        setPreviousClose(previousClose);
        setChange(change);
        this.changePercent = changePercent;
    }

    @Override
    public String toString() {
        return " {" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", price=" + price +
                ", volume=" + volume +
                ", latestTradingDay=" + latestTradingDay +
                ", previousClose=" + previousClose +
                ", change=" + change +
                ", changePercent=" + changePercent +
                '}';
    }
}
