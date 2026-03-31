package com.bank.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String _name;
    private String _firstname;
    private LocalDateTime _birthdate;

    public Person(String _name, String _firstname, LocalDateTime _birthdate) {
        this._name = _name;
        this._firstname = _firstname;
        this._birthdate = _birthdate;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_firstname() {
        return _firstname;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public LocalDateTime get_birthdate() {
        return _birthdate;
    }

    public void set_birthdate(LocalDateTime _birthdate) {
        this._birthdate = _birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person personne = (Person) o;
        return Objects.equals(_name, personne._name) && Objects.equals(_firstname, personne._firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _firstname);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "_name='" + _name + '\'' +
                ", _firstname='" + _firstname + '\'' +
                ", _birthdate=" + _birthdate +
                '}';
    }
}
