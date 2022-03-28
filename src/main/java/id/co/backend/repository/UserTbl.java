package id.co.backend.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "USER_TBL")
@Entity
public class UserTbl {

    @Id
    @Column(name="user_name", length = 32)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="is_active", nullable = false)
    private Integer isActive = 1;

    @Column(name="is_login", nullable = false)
    private Integer isLogin = 0;

}
