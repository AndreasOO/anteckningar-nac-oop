package OOP.Sprint1.Uppgift10.AccountAndLoanCreation;

public class AccountCreator {
    public static Account createNewAccount(double accountBalance, int accountInterestRate, int customerIDOfAccountOwner) {
        return new Account(accountBalance, accountInterestRate, customerIDOfAccountOwner);
    }
}
