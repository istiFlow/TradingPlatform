package hu.jst.demo.repository;

import hu.jst.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();

    @Query(value = "select * from users where user_name = ?1", nativeQuery = true)
    public User findByName(String userName);

/*    @Query(value = "delete from users where id = ?1", nativeQuery = true)
    public User update(long id);*/

}
