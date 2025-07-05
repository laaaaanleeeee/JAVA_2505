package com.data.business.service;

import com.data.business.dao.AccountDAO;
import com.data.business.dao.AccountDAOImpl;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();

    public boolean checkAccount(String userName, String pass) {
        return accountDAO.getAccount(userName, pass);
    }
}
