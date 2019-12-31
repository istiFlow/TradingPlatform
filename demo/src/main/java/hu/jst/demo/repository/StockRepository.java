package hu.jst.demo.repository;

import hu.jst.demo.entity.StockEntity;
import hu.jst.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    @Override
    public List<StockEntity> findAll();

    @Query(value = "select * from stocks where symbol = ?1", nativeQuery = true)
    public StockEntity findBySymbol(String symbol);

    @Query(value = "select ?1 from users where user_name = ?1", nativeQuery = true)
    public String findBySymbol2(String symbol);
}
