package hu.jst.demo.repository;

import hu.jst.demo.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    @Override
    public List<StockEntity> findAll();

    @Query(value = "select * from stocks where symbol = ?1", nativeQuery = true)
    public StockEntity findBySymbol(String symbol);

    @Modifying
    @Transactional
    @Query(value = "UPDATE stocks SET " +
            "change_ = ?2 ,change_percent = ?3,high = ?4,latest_trading_day = ?5, low = ?6, open_ = ?7, previous_close = ?8,price = ?9,volume = ?10 " +
            "WHERE symbol = ?1", nativeQuery = true)
    public void update(String symbol,
                               Double change,
                       String changePercent,
                       Double high,
                       LocalDate latestTradingDay,
                       Double low,
                       Double open,
                       Double previousClose,
                       Double price,
                       Integer volume
                              );

    @Query(value = "SELECT EXISTS(SELECT * FROM stocks WHERE symbol = ?1)", nativeQuery = true)
    public int isExist(String symbol);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM stocks WHERE symbol = ?1", nativeQuery = true)
    public void deleteByEmail (String symbol);

}
