package ru.inno.task;

import java.util.*;


interface Save {
    void load();
}

interface Action {
    void make();
}

public class Account {
    private class SaveImpl implements Save {

        private String name = Account.this.name;
        private Map<Account.Currency, Integer> values = new HashMap<>(Account.this.values);

        public void load() {
            Account.this.name = name;
            Account.this.values = new HashMap<>(values);
        }

    }

    private String name;
    private Map<Currency, Integer> values = new HashMap<>();

    Deque<Action> deque = new ArrayDeque<>();

    public Account(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        String tmp = this.name;
        deque.push(() -> Account.this.name = tmp);
        this.name = name;
    }

    public void addCur(Currency cur, int val) {

        if (val < 0) throw new IllegalArgumentException();
        int tmp;
        if (values.get(cur) != null) {
            tmp = values.get(cur);
        } else {
            tmp = 0;
        }

        deque.push(() -> Account.this.values.put(cur, tmp));
        values.put(cur, val);
    }

    public Map<Currency, Integer> getValues() {
        return new HashMap<>(values);
    }

    public void undo() {
        deque.pop().make();
    }

    public SaveImpl save() {
        return new SaveImpl();
    }

    public enum Currency {
        RUB("Рубли"), EUR("Евро"), USD("Доллары");

        private String name;

        Currency(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(name);
            return sb.toString();
        }


    }

}






