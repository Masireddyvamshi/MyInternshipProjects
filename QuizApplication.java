
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}


class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }

    public int getQuestionCount() {
        return questions.size();
    }
}


public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of Telagana?", new String[]{"hyderabad", "delhi", "chennai"}, 0));
        quiz.addQuestion(new Question("what is our national bird?", new String[]{"eagle", "parrot", "peacock"}, 2));
        quiz.shuffleQuestions();

        Scanner s = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getQuestionText());
            for (int j = 0; j < question.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + question.getOptions()[j]);
            }
            System.out.print("Enter your answer: ");
            int userAnswer = s.nextInt() - 1;
            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectAnswer() + 1));
            }
        }

        System.out.println("Your score is: " + score + "/" + quiz.getQuestionCount());
    }
}

