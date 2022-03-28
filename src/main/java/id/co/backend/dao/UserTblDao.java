package id.co.backend.dao;

import id.co.backend.repository.UserTbl;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTblDao extends JpaRepository<UserTbl, String> {

    @Query("select a from UserTbl a where a.username = ?1 and a.password = ?2")
    UserTbl getUserByUsernameAndPassword(String username, String password);

    UserTbl  getUserTblByUsername(String userName);

}
