package hu.jst.demo.repository;

import hu.jst.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Query(value = "select * from user where user_name = ?1", nativeQuery = true)
    User findByName(String userName);
}
