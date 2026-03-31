package com.bank.models.accounts;

import com.bank.models.Person;

import java.util.Objects;

public class Current extends Account {
    //* ligneDeCredit (double) - Doit être supérieure ou égale à 0

    private double _credit;
    public Current(String _number, Person _holder, double _balance, double credit) {
        super(_number, _holder, _balance);
        setCredit(credit);
    }

    public double getCredit() {
        return _credit;
    }

    public void setCredit(double credit) {
        if(credit < 0) throw new RuntimeException("Credit cannot be a negative number");
        this._credit = credit;
    }

    @Override
    protected void withdraw(double amount) {
        withdraw(amount, this._credit);
    }

    @Override
    protected double calculateInterest() {
        //Dans Courant : si le solde est positif, le taux est de 3%, sinon il est de 9,75%.

        if(super.getBalance() > 0) return 0.03;
        else return 0.0975;
    }

    @Override
    public void applyInterest() {
        double newAmount = getBalance() - calculateInterest() * getBalance();
        withdraw(newAmount, this._credit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Current current = (Current) o;
        return Double.compare(_credit, current._credit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_credit);
    }

    @Override
    public String toString() {
        return super.toString() + ", Current{" +
                "_credit=" + _credit +
                '}';
    }
}
