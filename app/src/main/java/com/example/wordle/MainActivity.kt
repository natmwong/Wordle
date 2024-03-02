package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.WindowManager
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable declarations for textViews and button
        val guessLabel1 = findViewById<TextView>(R.id.textView3)
        val guessLabel2 = findViewById<TextView>(R.id.textView7)
        val guessLabel3 = findViewById<TextView>(R.id.textView13)
        val checkLabel1 = findViewById<TextView>(R.id.textView5)
        val checkLabel2 = findViewById<TextView>(R.id.textView9)
        val checkLabel3 = findViewById<TextView>(R.id.textView14)
        val guess1 = findViewById<TextView>(R.id.textView4)
        val guess2 = findViewById<TextView>(R.id.textView8)
        val guess3 = findViewById<TextView>(R.id.textView11)
        val correctness1 = findViewById<TextView>(R.id.textView6)
        val correctness2 = findViewById<TextView>(R.id.textView10)
        val correctness3 = findViewById<TextView>(R.id.textView12)
        val answer = findViewById<TextView>(R.id.textView15)
        val button = findViewById<Button>(R.id.button)
        val simpleEditText = findViewById<EditText>(R.id.et_simple)

        //Variable declarations for game
        var wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
        var guessesLeft = 3

        /**
         * Parameters / Fields:
         *   wordToGuess : String - the target word the user is trying to guess
         *   guess : String - what the user entered as their guess
         *
         * Returns a String of 'O', '+', and 'X', where:
         *   'O' represents the right letter in the right place
         *   '+' represents the right letter in the wrong place
         *   'X' represents a letter not in the target word
         */
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuess) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }

        // Function to hide all guess and correctness TextViews
        fun hideGuessAndCorrectnessViews() {
            listOf(guessLabel1, guess1, checkLabel1, correctness1,
                guessLabel2, guess2, checkLabel2, correctness2,
                guessLabel3, guess3, checkLabel3, correctness3).forEach {
                it.isVisible = false
            }
        }

        // Function to show guess and correctness TextViews
        fun showGuessAndCorrectnessViews(guessLabel: TextView, guess: TextView, checkLabel: TextView, correctness: TextView) {
            guessLabel.isVisible = true
            guess.isVisible = true
            checkLabel.isVisible = true
            correctness.isVisible = true
        }

        answer.text = wordToGuess
        answer.isVisible = false
        //hiding textViews on start
        hideGuessAndCorrectnessViews()

        /**
         * declare this once you press the guess button (if button is pressed then retrieve the text), subtract from guessesLeft
         * compare the text with the wordToGuess
         * update correctness to show hints
         * if checkGuesses is 0, change answer textView to display the wordToGuess change to restart
         */
        button.setOnClickListener {
            guessesLeft--
            Toast.makeText(it.context, "You have " + guessesLeft + " guesses left.", Toast.LENGTH_SHORT).show()
            if (guessesLeft >= 0) {
                button.text = "GUESS!"
                val userGuess = simpleEditText.text.toString().uppercase()
                simpleEditText.text.clear()
                when (guessesLeft) {
                    3 -> { //restarts game, clear all guesses and get new word
                        wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
                        answer.text = wordToGuess
                        answer.isVisible = false
                        hideGuessAndCorrectnessViews()
                    }
                    2 -> {
                        guess1.text = userGuess
                        correctness1.text = checkGuess(userGuess)
                        showGuessAndCorrectnessViews(guessLabel1, guess1, checkLabel1, correctness1)
                    }
                    1 -> {
                        guess2.text = userGuess
                        correctness2.text = checkGuess(userGuess)
                        showGuessAndCorrectnessViews(guessLabel2, guess2, checkLabel2, correctness2)
                    }
                    0 -> {
                        guess3.text = userGuess
                        correctness3.text = checkGuess(userGuess)
                        showGuessAndCorrectnessViews(guessLabel3, guess3, checkLabel3, correctness3)
                        answer.isVisible = true
                        button.text = "RESTART"
                        guessesLeft = 4 //Reset guessesLeft for a new game
                    }
                }
            }
        }
    }
}