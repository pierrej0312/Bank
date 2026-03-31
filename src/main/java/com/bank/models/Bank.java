package com.bank.models;

//**Classe Banque** :
//Attributs :
//nom (String) * comptes : Utilisez une Map<String, Courant> (en Java, on remplace l'indexeur C# par une collection de type clé/valeur pour retrouver un compte par son numéro).
//
//Méthodes :
//
//void ajouter(Courant compte) : ajoute un compte à la banque. * void supprimer(String numero) : supprime un compte via son numéro.
//* Courant getCompte(String numero) : remplace l'indexeur C# pour retourner un compte sur base de son numéro.

import com.bank.models.accounts.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.bank.models.accounts.Account.calculateBalancesSum;

public class Bank {
    private String _name;
    private HashMap<String, Account> _accounts;

    public Bank(String _name) {
        this._name = _name;
        this._accounts = new HashMap<>();
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public HashMap<String, Account> getAccounts() {
        return _accounts;
    }

    public Account getAccount(String accountNumber) {
        if(!_accounts.containsKey(accountNumber)) return null;
        return _accounts.get(accountNumber);
    }

    public Optional<Account> get(String num) {
        if(!_accounts.containsKey(num)) return Optional.empty();
        return Optional.of(_accounts.get(num));
    }

    public void addAccount(Account account) {
        if(getAccount(account.getNumber()) == null) _accounts.put(account.getNumber(), account);
    }

    public void deleteAccount(Account account) {
        if(!_accounts.containsKey(account.getNumber())) return;
        _accounts.remove(account.getNumber());
    }

    //Dans la classe Banque, ajoutez une méthode avoirDesComptes(Personne titulaire)
    // qui calcule le total des avoirs de tous les comptes appartenant à cette personne.

    public double getSumAccountsFromHolder(Person holder) {
        double sum = 0;
        List<Account> accounts = this._accounts.values().stream().filter(a -> a.getHolder().toString().equals(holder.toString())).toList();

        for(Account a: accounts) {
            calculateBalancesSum(a, sum);
        }
        return sum;
    }

    public String accountsToString() {
        StringBuilder str = new StringBuilder();
        for(Account a : _accounts.values()) {
            str.append(a.toString()).append(" | ");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(_name, bank._name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_name);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "_name='" + _name + '\'' +
                ", _accounts=" + accountsToString() +
                '}';
    }
}
