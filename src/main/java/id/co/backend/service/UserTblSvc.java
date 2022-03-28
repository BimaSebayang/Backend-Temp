package id.co.backend.service;

import id.co.backend.repository.UserTbl;

public interface UserTblSvc {

    UserTbl getUserTableByUsernameAndPassword(String username, String password);
    void logoutData(String username);

}
