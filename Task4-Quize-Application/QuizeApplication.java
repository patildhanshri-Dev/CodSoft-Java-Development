import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to create a class in Java?",
            "Which method is the starting point of a Java program?",
            "Which symbol is used to end a Java statement?",
            "Which company developed Java?"
        };

        String[][] options = {
            {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
            {"A. class", "B. ClassName", "C. create", "D. object"},
            {"A. start()", "B. main()", "C. run()", "D. execute()"},
            {"A. :", "B. .", "C. ;", "D. ,"},
            {"A. Microsoft", "B. Apple", "C. Sun Microsystems", "D. Google"}
        };

        char[] correctAnswers = {
            'A',
            'A',
            'B',
            'C',
            'C'
        };

        int score = 0;

        System.out.println("===== JAVA QUIZ =====");
        System.out.println("You have 10 seconds for each question.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("--------------------------------");
            System.out.println("Question " + (i + 1));
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer: ");

            long startTime = System.currentTimeMillis();

            String answer = sc.nextLine().toUpperCase();

            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("Time is over!");
            }
            else if (answer.length() > 0 &&
                     answer.charAt(0) == correctAnswers[i]) {

                System.out.println("Correct answer!");
                score++;
            }
            else {
                System.out.println("Wrong answer!");
            }

            System.out.println("Correct answer: "
                    + correctAnswers[i]);
        }

        System.out.println("\n===== QUIZ RESULT =====");

        System.out.println("Total Questions: "
                + questions.length);

        System.out.println("Correct Answers: "
                + score);

        System.out.println("Wrong Answers: "
                + (questions.length - score));

        System.out.println("Your Score: "
                + score + "/" + questions.length);

        sc.close();
    }
}
