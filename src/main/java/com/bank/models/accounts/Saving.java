package com.bank.models.accounts;

import com.bank.models.Person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Saving extends Account {

    private LocalDateTime _lastWithDraw;

    public Saving(String _number, Person _holder, double _balance) {
        super(_number, _holder, _balance);
    }

    public LocalDateTime get_lastWithDraw() {
        return _lastWithDraw;
    }

    public void set_lastWithDraw(LocalDateTime _lastWithDraw) {
        this._lastWithDraw = _lastWithDraw;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount, 0);
        _lastWithDraw = LocalDateTime.now();
    }

    @Override
    protected double calculateInterest() {
        return 0.045;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Saving saving = (Saving) o;
        return Objects.equals(_lastWithDraw, saving._lastWithDraw);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_lastWithDraw);
    }

    @Override
    public String toString() {
        return super.toString() + ", Saving{" +
                "_lastWithDraw=" + _lastWithDraw +
                '}';
    }
}
