import java.util.Scanner;
 
class BankAccount{
 
  private double balance;

  BankAccount(double balance){
  this.balance = balance;
}

public void deposit(double amount){
  if(amount > 0){
  balance = balance + amount;

  System.out.println("Amount deposited Successfully!");
}
  else{
  System.out.println("Invalid Deposit Amount.");
    }
}

  public void withdraw(double amount){
  if(amount <= 0){
  System.out.println("Invalid withdrawal amount");
}
  else if(amount > balance){
  System.out.println("Insuffisient Balance.");
}
  else{
  balance = balance - amount;

  System.out.println("Please collect your cash.");
  }
}

public double checkBalance(){
return balance;
}
}

class ATM{
private BankAccount account;

ATM(BankAccount account){
this.account = account;
}

public void displayMenu(){

Scanner sc = new Scanner(System.in);
int choice;

do{
System.out.println("\n======= ATM MENU =======");

System.out.println("1.Check Balnce");

System.out.println("2.Deposite Money");

System.out.println("3.Withdraw Money");

System.out.println("4.Exit");

System.out.print("Enter Your Choice: ");

 choice = sc.nextInt();

    switch (choice){
      case 1:
System.out.println("Current Balance: rs." + account.checkBalance());
      break;

      case 2:
System.out.print("Enter deposite amount: rs.");

double depositAmount = sc.nextDouble();

account.deposit(depositAmount);

System.out.print("Current Balance: rs." + account.checkBalance());
      break;
      
      case 3:

System.out.print("Enter withdrawal amount: rs.");

double withdrawalAmount = sc.nextDouble();

account.withdraw(withdrawalAmount);

System.out.print("Current Balance: rs." + account.checkBalance());
      break;

      case 4:
System.out.print("Thank You For Using The ATM");
      break;

    default:
System.out.println("Invalid Choice.");
  }
}
 while(choice != 4);
}
}

public class ATMInterface{
public static void main(String args[]){

BankAccount account = new BankAccount(10000);

ATM atm = new ATM (account);

System.out.println("===== WELCOME TO ATM =====");

atm.displayMenu();
}
}









