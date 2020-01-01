package hu.jst.demo.repository;

import hu.jst.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();

    @Query(value = "select * from users_login where email = ?1", nativeQuery = true)
    public User findByEmail (String userName);
}
