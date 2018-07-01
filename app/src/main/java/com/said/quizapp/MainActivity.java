package com.said.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when Submit Button is clicked .
     * It checks if all compulsory questions are answered if yes proceeds to calculate score if no display an error
     * It calculates score based on user's choice then displays it on screen
     */
    public void calculateScore(View view) {
        int score = 0; //Initialize Score to 0
        String remarks =""; //Store remarks based on the score

        /**
         * Finds a RadioGroup based on its Id indicated in its brackets.
         * This will help in checking if all questions are answered
         */
        RadioGroup choice_1 = findViewById(R.id.choices_1);
        RadioGroup choice_2 = findViewById(R.id.choices_2);
        RadioGroup choice_3 = findViewById(R.id.choices_3);
        RadioGroup choice_4 = findViewById(R.id.choices_4);
        RadioGroup choice_5 = findViewById(R.id.choices_5);
        RadioGroup choice_7 = findViewById(R.id.choices_7);
        RadioGroup choice_8 = findViewById(R.id.choices_8);
        RadioGroup choice_9 = findViewById(R.id.choices_9);

        //Find an EditText view with id indicated in brackets
        EditText choice_6 = findViewById(R.id.choice_6);

        //Get the text input from EditText View and convert it to String
        String choice_6_text = choice_6.getText().toString().trim();

        //Checks if all questions are answered if yes proceeds to calculate score if no displays error
        if (choice_1.getCheckedRadioButtonId() == -1 || choice_2.getCheckedRadioButtonId() ==-1 || choice_3.getCheckedRadioButtonId() ==-1 || choice_4.getCheckedRadioButtonId() ==-1 || choice_5.getCheckedRadioButtonId() ==-1 || choice_7.getCheckedRadioButtonId() ==-1 || choice_8.getCheckedRadioButtonId() ==-1 || choice_9.getCheckedRadioButtonId() ==-1 || choice_6_text.isEmpty() || choice_6_text.length() == 0 || choice_6_text.equals("") || choice_6_text == null)
        {
            displayError();
        }
        else
        {
            /**
             * Proceed to calculate score based on user choices
             * Find a radio button with id indicated in brackets.
             */
            RadioButton choice_1D = findViewById(R.id.choice_1D);
            RadioButton choice_2C = findViewById(R.id.choice_2C);
            RadioButton choice_3A = findViewById(R.id.choice_3A);
            RadioButton choice_4A = findViewById(R.id.choice_4A);
            RadioButton choice_5B = findViewById(R.id.choice_5B);
            RadioButton choice_7B = findViewById(R.id.choice_7B);
            RadioButton choice_8B = findViewById(R.id.choice_8B);
            RadioButton choice_9B = findViewById(R.id.choice_9B);


            //Get the boolean value of RadioButton and store it
            boolean choice_1D_checked = choice_1D.isChecked();
            boolean choice_2C_checked = choice_2C.isChecked();
            boolean choice_3A_checked = choice_3A.isChecked();
            boolean choice_4A_checked = choice_4A.isChecked();
            boolean choice_5B_checked = choice_5B.isChecked();
            boolean choice_7B_checked = choice_7B.isChecked();
            boolean choice_8B_checked = choice_8B.isChecked();
            boolean choice_9B_checked = choice_9B.isChecked();


            //Find a checkbox with id indicated in brackets
            CheckBox choice_10A = findViewById(R.id.choice_10A);
            CheckBox choice_10C = findViewById(R.id.choice_10C);

            //Get the boolean value of checkbox and store it
            boolean choice_10A_checked = choice_10A.isChecked();
            boolean choice_10C_checked = choice_10C.isChecked();

            //Convert the text input as an integer
            int choice_6_number = Integer.parseInt(choice_6_text);

            //If choice_1D is checked add 1
            if (choice_1D_checked) {
                score += 1;
            }
            //If choice_2C is checked add 1
            if (choice_2C_checked) {
                score += 1;
            }
            //If choice_3A is checked add 1
            if (choice_3A_checked) {
                score += 1;
            }
            //If choice_4A is checked add 1
            if (choice_4A_checked) {
                score += 1;
            }
            //If choice_5B is checked add 1
            if (choice_5B_checked) {
                score += 1;
            }
            //If choice_6 text input is 47 is add 1
            if (choice_6_number == 47) {
               score += 1;
            }
            //If choice_7B is checked add 1
            if (choice_7B_checked) {
                score += 1;
            }
            //If choice_8B is checked add 1
            if (choice_8B_checked) {
                score += 1;
            }
            //If choice_9B is checked add 1
            if (choice_9B_checked) {
                score += 1;
            }
            if (choice_10A_checked&&choice_10C_checked) {
                //add 1 to score if choice_10A and choice_10B is checked
                score += 1;

            }

            /**
             * Checks the score and determines remarks
             * If scores is 9 or Greater displays Genius
             * If score is 7 or greater displays Good
             * If scores is 4 or greater displays Nice Try
             * If scores is 3 or less displays not impressive
             */
            if (score >= 9) {
                remarks = "\nGenius";
            }
            else if (score >= 7) {
                remarks = "\nGood";
            }
            else if (score >= 4) {
                remarks = "\nNice Try";
            }
            else if (score <= 3) {
                remarks = "\nNot Impressive";
            }

            String yourScore = "Your score\n" + score + remarks;
            TextView scoresTextView =  findViewById(R.id.scores);
            scoresTextView.setText(yourScore);// Displays Scores and remarks on Screen
            Toast.makeText(this, yourScore, Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * This method is called when there is an unanswered question.
     * It displays an error when there is unanswered questions
     */
   public void displayError() {
       TextView scoreTextView =  findViewById(R.id.scores);
       scoreTextView.setText(R.string.error);
       Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();

   }


}
