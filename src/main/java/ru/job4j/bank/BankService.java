package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "банковская система" и реализовывает методы:
 * добавления пользователя в систему, добавления счетов пользователя, поиска пользователя по паспортным данным,
 * перевода денежных средств
 * @author Artem Shmelev
 * @version 1.0
 */
public class BankService {
    /**
     * Карта хранит список пользователей и их списки счетов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в систему, если он отсутствует
     * @param user принимается пользователь для добавления в карту users
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет аккаунт пользователя с указанными паспортными данными
     * Если пользователь существует, а такого счета еще нет, то указанный счет
     * будет добавлен в список счетов пользователя
     * @param passport принимает паспортные данные
     * @param account принимает банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспортным данным
     * возвращает пользователя в случае успешного поиска или null в противном случае
     * @param passport принимает паспортные данные
     * @return возвращает пользователя в случае успешного поиска или null в противном случае
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет банковский счет по паспортным данным пользователя и реквизитам счета
     * Если пользователь не найден, то поиск прекращается, если найдет, то просиходит поиск
     * счета по реквизитам по всем счетам данного пользователя
     * @param passport принимает паспортные данные
     * @param requisite принимает реквизиты искомого счета
     * @return возвращает банковский счет в случае успешного поиска или null в противном случае
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод обеспечивает перевод средств между счетами одного или нескольких пользователей
     * Если существуют счета истоника и приемника, а так же хватает средств на счете источнике,
     * то перевод будет осуществлен успешно.
     * @param srcPassport принимает паспортные данные отправителя
     * @param srcRequisite принимает реквизиты отправителя
     * @param destPassport принимает паспортные данные получателя
     * @param destRequisite принимает реквизиты получателя
     * @param amount принимает сумму перевода
     * @return возвращает true  в случае успешного перевода и false - в противном случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accDest != null && accSrc != null && accSrc.getBalance() >= amount) {
            accDest.setBalance(accDest.getBalance() + amount);
            accSrc.setBalance(accSrc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}