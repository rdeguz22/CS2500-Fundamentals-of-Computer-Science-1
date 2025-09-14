# SUMMARY

Answer all the questions. Please put your answers _after_ the brackets with
point values.

## Transcripts

Paste transcripts into the below sections. Put each within triple back-quotes,
like this:

```
This is an example.
```

All transcripts should start with the first text output from the program.
Provide a transcript even if your code did not work correctly. **Do not** modify
transcripts.

### Transcript 1

_Paste in the transcript for Problem 1. It should show at least one win and one loss
with the text-human combination._ [5 points]

```
9:48:36 PM: Executing 'runTextWithHuman'...

> Task :compileKotlin UP-TO-DATE
> Task :compileJava NO-SOURCE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE
> Task :jar UP-TO-DATE
> Task :inspectClassesForKotlinIC UP-TO-DATE

> Task :runTextWithHuman
Input guess: 
earth
EARTH -> ....+
Input guess: 
happy
HAPPY -> *...*
Input guess: 
score
SCORE -> +....
Input guess: 
fussy
FUSSY -> .**.*
Input guess: 
words
WORDS -> ....+
Input guess: 
husky
HUSKY -> *****
Phew

BUILD SUCCESSFUL in 43s
5 actionable tasks: 1 executed, 4 up-to-date
9:49:19 PM: Execution finished 'runTextWithHuman'.
```

```
9:50:53 PM: Executing 'runTextWithHuman'...

> Task :compileKotlin UP-TO-DATE
> Task :compileJava NO-SOURCE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE
> Task :jar UP-TO-DATE
> Task :inspectClassesForKotlinIC UP-TO-DATE

> Task :runTextWithHuman
Input guess: 
words
WORDS -> ....+
Input guess: 
words
WORDS -> ....+
Input guess: 
words
WORDS -> ....+
Input guess: 
words
WORDS -> ....+
Input guess: 
words
WORDS -> ....+
Input guess: 
words
WORDS -> ....+
Secret word: STIFF

BUILD SUCCESSFUL in 20s
5 actionable tasks: 1 executed, 4 up-to-date
9:51:13 PM: Execution finished 'runTextWithHuman'.

```

### Transcript 2

_Paste in the transcript for Part 2._ [5 points]

```
12:28:03 PM: Executing 'runTextWithAI'...

> Task :processResources UP-TO-DATE
> Task :compileKotlin
> Task :compileJava NO-SOURCE
> Task :classes UP-TO-DATE
> Task :jar
> Task :inspectClassesForKotlinIC

> Task :runTextWithAI
ADIEU -> ....+
GURKS -> .*.*+
MUSKY -> .****
TUSKY -> .****
BUSKY -> .****
HUSKY -> *****
Phew

BUILD SUCCESSFUL in 6s
5 actionable tasks: 4 executed, 1 up-to-date
12:28:10 PM: Execution finished 'runTextWithAI'.
```

## Logistics

### Did you successfully implement everything that was requested?

_Answer "Yes", or state here which parts did not work or which tests did not
pass._ [1 point]

Yes

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]

1 hour.

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours. We especially
like hearing about helpful TAs._ [1 points]

Pair programming with Ricardo de Guzman. I did not attend any office hours.

### What was your AI usage?

_State explicitly (yes or no) whether you used AI. If so, say which tools you
used and what your prompts were. Your assignment will not be graded if you do
not answer this question._ [1 point]

I did not use AI.

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which
ones were particularly helpful._ [2 points]

I used the class slides, and the kotlin library.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

_Constructive and actionable suggestions for improving assignments, office
hours, and lecture are always welcome._
[4 points]

The most difficult part of the assignment was adding the constraint for gray/'.' characters.
The most rewarding part of the assignment was implementing the AI and watching it work on numerous words.
I learned more about constraints and function types doing this assignment.
