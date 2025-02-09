package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает сущность "банковская система" и реализовывает методы:
 * добавления пользователя в систему, добавления счетов пользователя, поиска пользователя
 * по паспортным данным, перевода денежных средств
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Метод ищет банковский счет по паспортным данным пользователя и реквизитам счета
     * Если пользователь не найден, то поиск прекращается, если найдет, то просиходит поиск
     * счета по реквизитам по всем счетам данного пользователя
     * @param passport принимает паспортные данные
     * @param requisite принимает реквизиты искомого счета
     * @return возвращает банковский счет в случае успешного поиска или null в противном случае
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(acc -> requisite.equals(acc.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> accSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accDest = findByRequisite(destPassport, destRequisite);
        if (accDest.isPresent() && accSrc.isPresent() && accSrc.get().getBalance() >= amount) {
            accDest.get().setBalance(accDest.get().getBalance() + amount);
            accSrc.get().setBalance(accSrc.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}