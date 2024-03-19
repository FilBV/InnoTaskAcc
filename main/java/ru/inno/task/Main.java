package ru.inno.task;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Account acc = new Account("Устинов Сергей Иванович");
        acc.addCur(Account.Currency.RUB, 59);
        acc.addCur(Account.Currency.EUR, 25);
        acc.setName("Иванов Петр Сергеевич");
        acc.addCur(Account.Currency.RUB, 74);
        acc.addCur(Account.Currency.USD, 62);
        Save save = acc.save();
        acc.undo();
        Date date = new Date();
        System.out.println(date);


    }

}
