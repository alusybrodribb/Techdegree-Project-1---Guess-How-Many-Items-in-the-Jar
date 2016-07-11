**************************************
Guess the Number of Objects in the Jar
**************************************
Alison (Lusy) Brodribb (nee Parker)
July 2016

This is my first Java application, which I am making as part of
the Treehouse Techdegree

Please see below for console commands associated with this game:


1. Initialising the Game
**************************

To initialise the game, run the Game class on your Java console,
and add in the following arguments:
  Type of Object
  Maximum no of Objects in jar
  (java Game ObjectType MaxObjects)
Please make sure that no of objects is entered as an Integer

2. Checking High Scores
**************************

//Upon reading the instructions prior to submitting, it looks like
//I misunderstood them and didn't actually have to add this particular
//functionality to my project. Oh well.

To check high scores, run the Game class without entering any
arguments (java Game). Only three high scores are stored at any
one time.

Scores are calculated as follows:

Score = Max objects in jar / no of guesses

This means that higher scores are possible for jars with more
objects (i.e. more difficult jars get higher scores). I'm
not 100% happy with this way of calculating scores, but I'm not
sure what calculation method would be the best at the moment,
so I'm sticking with this.

2. Resetting High Scores
**************************

To reset high scores enter the single argument "reset"
(java Game reset).

This will reset all high scores to Anon: 0.


*********************
Error Catching Info
*********************
The game checks for the following errors upon initializing:

Checks for correct number of args
Checks that 2nd arg can be parsed as an integer

The following errors are checked during the game:

Checks that player inputs a number
Checks that number is within correct range for game
