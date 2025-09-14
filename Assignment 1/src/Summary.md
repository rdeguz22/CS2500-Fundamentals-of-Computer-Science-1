# SUMMARY

Answer all the questions. Please put your answers _after_ the italicized instructions
and point values.

## Homework 1

### Conversation transcript

_Paste in the transcript of your conversation between the triple back-quotes._ [3 points]

```
/Users/ricardo.deguzman/Library/Java/JavaVirtualMachines/corretto-21.0.4/Contents/Home/bin/java -Dkotlin.repl.ideMode=true -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 @/private/var/folders/09/2dzlc_7x48q61zr6vg49n2400000gn/T/idea_arg_file1236923552
Kotlin IDE REPL support is experimental. It may be slow or unstable. Please, report problems to https://youtrack.jetbrains.com/issues/KTIJ.
Welcome to Kotlin version 1.9.24-release-822 (JRE 21.0.4+7-LTS)
Type :help for help, :quit for quit

converse()
What is your name?Rico
Hello, Rico!What is your favorite food?Pizza
Your favorite food is Pizza!What is your favorite song?2024
Your favorite song is 2024
```

### Debugging

_How did you find the bug in the original `CharacterGenerator.kt`? Was it by
looking at the code, running the code, or talking with another student?_ [1 point]
I ran the code multiple times in the REPL and realized all outputs were multiple of 3, meaning the 3 random numbers generated were the same.
### CharacterGenerator transcript

_Paste in the transcript of your conversation between the triple back-quotes._ [6 points]

```
/Users/ricardo.deguzman/Library/Java/JavaVirtualMachines/corretto-21.0.4/Contents/Home/bin/java -Dkotlin.repl.ideMode=true -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 @/private/var/folders/09/2dzlc_7x48q61zr6vg49n2400000gn/T/idea_arg_file598133879
Kotlin IDE REPL support is experimental. It may be slow or unstable. Please, report problems to https://youtrack.jetbrains.com/issues/KTIJ.
Welcome to Kotlin version 1.9.24-release-822 (JRE 21.0.4+7-LTS)
Type :help for help, :quit for quit

makeCharacter()
Enter your character's name:Rico
res0: kotlin.String = Rico has charisma 15, agility 9, and speed 8.

makeHero()
Enter your character's name:Rico
res2: kotlin.String = Rico has charisma 10, agility 14, and speed 16.

makeAdventurer()
Enter your character's name:Rico
Enter minimum value:2
Enter maximum value:8
res3: kotlin.String = Rico has charisma 16, agility 18, and speed 15.

```

## Logistics

This section is usually the same for every assignment.

### Did you successfully implement everything that was requested, to the best of your knowledge?

_Answer "Yes", or state here which parts did not work or which tests did not pass._ [1 point]
Yes

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]
1.5 hours

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours._ [1 points]
I worked with Doug Conrad and we discussed what the questions actually asked and held each other accountable in getting the assignment done.
### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which ones were
particularly helpful. State whether you used AI and, if so, which tools you used and how
you used them._ [2 points]
I used https://kotlinlang.org/docs/control-flow.html to find the syntax for functions that I didn't know, but used in other languages.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* How did the assignment go?
* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment? Were there any learning outcomes
  (shown near the top of the Canvas page) you did not achieve?

_Constructive and actionable suggestions for improving assignments, office hours,
and lecture are always welcome._
[5 points]

The assignment was a process for sure. I think it went well. Most of the difficulty came in the setup,
just setting up the REPL and getting it to work took some trouble. The most difficult part of the actual assignment was figuring out how to debug the code.
Finding the bug was not as difficult as figuring out the fix for the bug, which required learning some new syntax on my own that was not covered in class.
The most rewarding part of the assignment was seeing the functions actually work and be usable. I learned some new syntax on functions and just to keep going.
This is just the beginning of the long process that this is a part of. I'm looking forward to it.
