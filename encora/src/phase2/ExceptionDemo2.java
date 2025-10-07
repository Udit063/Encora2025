package phase2;
//throw, throws and finally
public class ExceptionDemo2 {
	public static void main(String[] args) {//throws LowBalanceException {
		Customer customer=new Customer();
		customer.useATM(new Atm());
	}
}
//custom exception
class Customer{
	public void useATM(Atm atm) {//throws LowBalanceException{
		System.out.println("before exception....");
		try{ 
			atm.withdraw(5000);
		}catch(LowBalanceException lb) {
			lb.printStackTrace();
		}finally {
			System.out.println("finally called....");
		}
		System.out.println("after exception....");
	}
}
class LowBalanceException extends Exception{
	String msg;
	public LowBalanceException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
}
class Atm{
	int balance=1000;
	public void withdraw(int amount)throws LowBalanceException {
		if(amount>balance) {
			
			throw new LowBalanceException("your balance is low..please refill");  // exception ko explicitly call kr rhe hai
			
		}
	}
}

