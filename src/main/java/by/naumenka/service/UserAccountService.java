package by.naumenka.service;

import by.naumenka.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountService {

    UserAccount createUserAccount(UserAccount userAccount);

    UserAccount getUserAccountById(long id);

    UserAccount getUserAccountByUserId(long userId);

    UserAccount topUpUserAccount(long userId, BigDecimal money);

    UserAccount withdrawMoneyFromAccount(long userId, BigDecimal money);

}