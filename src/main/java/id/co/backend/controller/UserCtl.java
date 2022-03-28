package id.co.backend.controller;

import id.co.backend.dao.UserTblDao;
import id.co.backend.repository.UserTbl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserCtl {

    private final UserTblDao userTblDao;

    @PostConstruct
    void createUserApps(){
        UserTbl userTbl1 =  new UserTbl();
        userTbl1.setUsername("bima01");
        userTbl1.setPassword("Roxas0309.");
        userTbl1.setIsLogin(0);
        userTbl1.setIsActive(1);
        UserTbl userTbl2 =  new UserTbl();
        userTbl2.setUsername("bima02");
        userTbl2.setPassword("Roxas0310.");
        userTbl2.setIsLogin(0);
        userTbl2.setIsActive(0);
        UserTbl userTbl3 = new UserTbl();
        userTbl3.setUsername("bima03");
        userTbl3.setPassword("Roxas0311.");
        userTbl3.setIsLogin(1);
        userTbl3.setIsActive(1);

        List<UserTbl> userTbls = new ArrayList<>();
        userTbls.add(userTbl1);
        userTbls.add(userTbl2);
        userTbls.add(userTbl3);

        userTblDao.saveAll(userTbls);
    }

}
