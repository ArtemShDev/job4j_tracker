package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс-модель который описывает сущность "счёт"
 * Объекты этого класса используются для заполнения карты в объектах класса BankService
 * @author Artem Shmelev
 * @version 1.0
 */
public class Account {
    /**
     * Поле хранит реквизиты счета
     */
    private String requisite;
    /**
     * Поле хранит текущий баланс счета
     */
    private double balance;

    /**
     * Конструктор, устанавливающий значение полей объекта
     * @param requisite реквизиты счета
     * @param balance   баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер, возвращающий реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер, устанавливающий реквизиты счета
     * @param requisite принимаются реквизиты счета и устанавливаются в качестве значения поля
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер, возвращающий баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер, устанавливающий баланс счета
     * @param balance принимается актуальные баланс счета и устанавливаются в качестве значения поля
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

     /**
     * Переопределенный метод класса Object для сравнения объектов текущего класса
     * по полям requisite
      * @param o Принимается объект класса Object
      * @return Возвращается результат сравнения полей requisite (false или true)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод класса Object для сравнения объектов текущего класса
     * @return возвращает целое число (хэш-код) на основании переданного значения requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}