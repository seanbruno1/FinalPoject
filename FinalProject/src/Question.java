
public class Question {
    String Question;
    int Answer;

    public Question(String q,int a){
        Question = q;
        Answer = a;
    }
    void getQuestion(){
        System.out.println(this.Question);
    }
    int getAnswer(){
        return Answer;
    }
  
}
