package opel_demo;

public class AccountWithSecurityCheck implements IAccount {
    private IAccount account;

    public AccountWithSecurityCheck(IAccount IAccount) {
        this.account = IAccount;
    }

    public void operation() {
        SecurityChecker.checkSecurity();
        account.operation();
    }
}