package ru.job4j.bank;

import java.util.Objects;

 /**
 * Класс-модель который описывает сущность "пользователь"
 * Объекты этого класса используются для заполнения карты в объектах класса BankService
 * @author Artem Shmelev
 * @version 1.0
 */
public class User {
    /**
     * Поле хранит серию и номер паспорта
     */
    private String passport;
     /**
      * Поле хранит ФИО пользователя
      */
    private String username;

    /**
     * Конструктор, устанавливающий значение полей объекта
     * @param passport Принимается серия и номер паспорта
     * @param username Принимается ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер возвращает паспортные данные пользователя
     * @return возвращает паспортные данные пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер устанавливает паспортные данные пользователя
     * @param passport Принимается серия и номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер возвращает ФИО пользователя
     * @return возвращает ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер устанавливает ФИО пользователя
     * @param username Принимается ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод класса Object для сравнения объектов текущего класса
     * по полям passport
     * @param o Принимается объект класса Object
     * @return Возвращается результат сравнения полей passport (false или true)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод класса Object для сравнения объектов текущего класса
     * @return возвращает целое число (хэш-код) на основании переданного значения passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}