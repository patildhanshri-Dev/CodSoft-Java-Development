import java.util.Scanner;
import java.util.Random;

class NumberGame{
 public static void main(String args[]){
  Scanner sc = new Scanner (System.in);
  Random rd = new Random();

   int score = 0;
   char playagain;
do{
 int number = rd.nextInt(100) + 1;
 int attempts = 0;
 int maxAttempts = 7;
 Boolean correct = false;

System.out.println("\n=========Number Game---------");
System.out.println("I have genrated a number between 1 and 100.");
System.out.println("You have " + maxAttempts + " attempts.");
 
while(attempts < maxAttempts){
System.out.println("Enter your guess: ");

int guess = sc.nextInt();

attempts++;

if(guess == number){
System.out.println("Correct!");

System.out.println("You guessed it in " + attempts + " attempts ");
score++;
correct = true;
break;
}
else if(guess < number){
System.out.println("Too low!");
}
else{
System.out.println("Too High!");
}
}

if(!correct){
System.out.println("Sorry! You used all your attempts.");

System.out.println("The correct number was: " + number);
}

System.out.println("Do you want to play again ? (y/n): ");
playagain = sc.next().charAt(0);

}

while(playagain == 'y' || playagain == 'Y');

System.out.println("\n=========Game Over=========");
System.out.println("Your score is: "+ score);

sc.close();
}
}











