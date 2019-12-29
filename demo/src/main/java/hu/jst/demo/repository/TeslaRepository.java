package hu.jst.demo.repository;

import hu.jst.demo.entity.TeslaQuoteEntity;
import hu.jst.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeslaRepository extends CrudRepository<TeslaQuoteEntity, Long> {
    @Override
    public List<TeslaQuoteEntity> findAll();
}
