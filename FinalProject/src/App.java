import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcom to the Stanley Cup Champions Quiz!");
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your Name? : ");
        String UserName = sc.nextLine().trim();
        if (UserName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        UserName = UserName.replaceAll("[^a-zA-Z0-9_ ]", "");
        System.out.println("Good Luck "+ UserName+"!");

        Question q1 = new Question("When was the last time the New York Rangers won the Stanley Cup?",1994);
        Question q2 = new Question("When was the last time the Montreal Canadiens won the Stanley Cup?",1993);
        Question q3 = new Question("When was the last time the New York Islanders won the Stanley Cup?",1984);

        q1.getQuestion();
        int Score =0;
        int answer1 = q1.getAnswer();
        int userAnswer1 = sc.nextInt();
        
        if(answer1 == userAnswer1){
            System.out.println("Correct\n");
            Score = Score +1;
        }else{
            System.out.println("Wrong!\n");
        }

        q2.getQuestion();
        int answer2 = q2.getAnswer();
        int userAnswer2 = sc.nextInt();
        if(answer2 == userAnswer2){
            System.out.println("Correct\n");
            Score = Score +1;
        }else{
            System.out.println("Wrong!\n");
        }

        q3.getQuestion();
        int answer3 = q3.getAnswer();
        int userAnswer3 = sc.nextInt();
        if(answer3 == userAnswer3){
            System.out.println("Correct\n");
            Score = Score +1;
        }else{
            System.out.println("Wrong!\n");
        }
        File inputFile = new File("Scores.txt");
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("Scores.txt",true));
        writer.write(UserName + " Score : "+ Score + "\n");
        writer.close();
        } catch (FileNotFoundException e){
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        if(Score == 3){
            System.out.println("Congrats you got a "+Score+"/3 which is the best score!\n");
        }else{
            System.out.println("You got a "+Score+"/3 not get the best score, better luck next time :(\n");
        }

        try {
            Scanner scanner = new Scanner(inputFile);
            List<String> HighScorelist = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Score : 3")) {
                   
                    String username = line.split(" Score :")[0].trim();
                    HighScorelist.add(username);  
                }
            }
            

            
            System.out.println("Users with a perfect score: ");
            for (String username : HighScorelist) {
                System.out.println(username);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        
    }
   

}




        
        
        


