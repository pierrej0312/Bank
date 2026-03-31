package com.bank.models.accounts;

import com.bank.models.Person;

import java.util.Objects;

public abstract class Account {
    //numero (String) * solde (double) - Lecture seule (pas de Setter public)
    //
    //titulaire (objet de type Personne)
    //
    //Méthodes publiques :
    //
    //void retrait(double montant) : déduit le montant du solde. * void depot(double montant) : ajoute le montant au solde.

    private String _number;
    private Person _holder;
    private double _balance;

    public Account(String _number, Person _holder, double _balance) {
        this._number = _number;
        this._holder = _holder;
        this._balance = _balance;
    }

    public String getNumber() {
        return _number;
    }

    public void setNumber(String _number) {
        this._number = _number;
    }

    public Person getHolder() {
        return _holder;
    }

    public void setHolder(Person _holder) {
        this._holder = _holder;
    }

    public double getBalance() {
        return _balance;
    }

    protected void withdraw(double amount) {
        withdraw(amount, 0);
    }
    protected void withdraw(double amount, double credit) {
        if(amount > this._balance + credit || amount < 0) {
            throw new RuntimeException("You cannot take over: " + (this._balance + credit));
        }
        this._balance -= amount;
    }
    protected void deposite(int amount) {
        if(amount < 0) throw new RuntimeException("Error, you cannot deposite a negative number");
        this._balance += amount;
    }
//    public static double add(Account a, Account b) {
//        return a._balance + b._balance;
//    }
//    public static double add(double value, Account a) {
//        return value + a._balance;
//    }
    //Dans la classe Courant, créez une méthode statique (ou d'instance)
    // calculerSommeSoldes(Courant c1, Courant c2) qui retourne la somme des soldes.
    // Les soldes négatifs doivent être ignorés (comptés comme 0).


    public static double calculateBalancesSum(Account a, double sum) {
        return sum + cleanNegativeBalance(a._balance);
    }
    private static double cleanNegativeBalance(double num) {
        if(num < 0) return 0;
        else return num;
    }

    protected abstract double calculateInterest();

    public void applyInterest() {
        double newAmount = getBalance() - calculateInterest() * getBalance();
        withdraw(newAmount, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(_number, account._number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_number);
    }

    @Override
    public String toString() {
        return "Account{" +
                "_number='" + _number + '\'' +
                ", _holder=" + _holder +
                ", _balance=" + _balance +
                '}';
    }
}
