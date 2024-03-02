# Android Project 1 - *Wordle*

Submitted by: **Natasha Wong**

**Wordle** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **6** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User has 3 chances to guess a random 4 letter word**
- [X] **After 3 guesses, user should no longer be able to submit another guess**
- [X] **After each guess, user sees the "correctness" of the guess**
- [X] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle betweeen different word lists
- [ ] User can see the 'correctness' of their guess through colors on the word 
- [ ] User sees a visual change after guessing the correct word
- [X] User can tap a 'Reset' button to get a new word and clear previous guesses
- [ ] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
![wordleDemo](https://github.com/natmwong/AND102Wordle/assets/114623813/e115a0e2-c31e-46b1-9aa2-5f6fbf26d194)

GIF created with ScreenToGif

## Notes

One of the main challenges I had with this project was figuring out how to make the textViews of the guesses and correctness checks visible after pressing the guess button.
I set all the textViews' visibility as false at the start of the app. Originally, I attempted setting the visibilities of the guesses and correctness checks in each seperate instance of guessesLeft.
This approach did not work, however, and none of the textViews would be visible after pressing the guess button. The solution I found was to create a function to show the textViews with the parameters
of the guesses and correctness checks of that guess instance.

## License

    Copyright [2024] [Natasha Wong]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
