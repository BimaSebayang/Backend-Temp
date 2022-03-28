package id.co.backend.service.impl;

import id.co.backend.dao.UserTblDao;
import id.co.backend.repository.UserTbl;
import id.co.backend.service.UserTblSvc;
import id.co.backend.throwable.ExistingDataException;
import id.co.backend.throwable.NotFoundDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
public class UserTblSvcImpl implements UserTblSvc {

    @Autowired
    private UserTblDao userTblDao;


    @Override
    public UserTbl getUserTableByUsernameAndPassword(String username, String password) {
        UserTbl userTbl = userTblDao.getUserByUsernameAndPassword(username,password);

        if(Objects.isNull(userTbl)){
            throw new NotFoundDataException("Username atau password masih salah.");
        }

        else if(userTbl.getIsLogin()==1){
            throw  new ExistingDataException("username ini sudah login");
        }

        else if(userTbl.getIsActive()==0){
            throw  new NotFoundDataException("username ini tidak aktif");
        }

        userTbl.setIsLogin(1);
        userTblDao.save(userTbl);
        return userTbl;
    }

    @Override
    public void logoutData(String username) {
        UserTbl userTbl = userTblDao.getUserTblByUsername(username);
        userTbl.setIsLogin(0);
    }
}
