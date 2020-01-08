package hu.jst.demo.repository;

import hu.jst.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    public List<User> findAll();

    //@Query(value = "select * from users_login where email = ?1", nativeQuery = true)
    public User findByEmail (String userName);

    @Transactional
    @Modifying
    @Query(value = "delete from  users_login where email = ?1", nativeQuery = true)
    public void deleteByEmail (String email);

    @Query(value = "SELECT EXISTS(SELECT * FROM users_login WHERE email = ?1)", nativeQuery = true)
    public int isExist(String email);
}
