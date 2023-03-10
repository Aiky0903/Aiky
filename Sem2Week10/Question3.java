import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Question3
{
    @Test
    void BalanceShouldBe1000() {
    	BankAccount account = new BankAccount();
    	account.deposit(1000);
    	assertEquals(1000, account.getBalance());
    }
    
    @Test 
    void BalanceShouldBe500(){
    	var account = new BankAccount(1000);
    	account.withdraw(500);
    	assertEquals(500, account.getBalance());
    }
    
    @Test
    void TransferTest() {
    	var account = new BankAccount(1000);
    	var otherAccount = new BankAccount(1000);
    	account.transfer(500, otherAccount);
    	assertEquals(500, account.getBalance());
    	assertEquals(1500, otherAccount.getBalance());
    }
}
