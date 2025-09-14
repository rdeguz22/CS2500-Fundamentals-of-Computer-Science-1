# SUMMARY

Answer all the questions. Please put your answers _after_ the italicized
instructions.

## Transcripts

### Transcript 1 (Problem 2)

_Paste in the transcript excerpts showing proper handling of the 7
post conditions, labeling them by name or number._

```
//`Show first post` is not shown when there are no posts.
//Pluralization is handled properly when there are no posts.
//take(0) being used.
Hello, douglasconrad1.
Select an option: 
	0. Quit
	1. Select a subreddit
1
What subreddit would you like to select? 
neu
You are now in NEU.
There are no posts.

Process finished with exit code 0

```

```
//`Show first post` is shown when there is a first post.
//`Show next post` is not shown when there is not a next post.
//Pluralization is handled properly when there is a single post.
//take(1) being used.
What subreddit would you like to select? 
neu
You are now in NEU.
There is one post.
Select an option: 
	0. Quit
	1. Show first post
	2. Select a subreddit
1
THANKSGIVING 

What are your thanksgiving plans as an int’l student. 

Select an option: 
	0. Quit
	1. Show post author
	2. Check for comments
	3. Select a subreddit
0

Process finished with exit code 0
```

```
//`Show next post` is shown when there is a next post.
//Pluralization is handled properly when there are multiple posts.
/Users/dougconrad/Library/Java/JavaVirtualMachines/corretto-21.0.4/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=51363:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/dougconrad/IdeaProjects/Fundies1-Homework11/build/classes/kotlin/main:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.7.21/5407c3593c58860cec5ee3f66c468396b42f4c2b/kotlin-stdlib-jdk8-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/com.github.masecla22/Reddit4J/2fb38684f6/c2bfbb68289278fe640500f89068b0c8e5cf1b82/Reddit4J-2fb38684f6.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.7.21/a0ba09615c2213d580315e234b3febfea25b757e/kotlin-stdlib-jdk7-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.7.21/1a2eaf898a0dda83037034b10a42053cf8a7caf8/kotlin-stdlib-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jsoup/jsoup/1.16.1/ae551410a16433984cd4a8603622fafa9d8299f0/jsoup-1.16.1.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/com.google.code.gson/gson/2.10.1/b3add478d4382b78ea20b1671390a858002feb6c/gson-2.10.1.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.7.21/cb02257de8e13e8498f8e2f69f742f2d438e794d/kotlin-stdlib-common-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar ClientKt
Hello, douglasconrad1.
Select an option: 
	0. Quit
	1. Select a subreddit
1
What subreddit would you like to select? 
neu
You are now in NEU.
There are 21 posts.
Select an option: 
	0. Quit
	1. Show first post
	2. Select a subreddit
1
THANKSGIVING 

What are your thanksgiving plans as an int’l student. 

Select an option: 
	0. Quit
	1. Show post author
	2. Check for comments
	3. Show next post
	4. Select a subreddit
3
EASY/FUN DIALOGUE RECOMMENDATIONS?

i’m a senior who needs to fill random elective credits so i’m thinking of doing a dialogue — any recommendations for dialogues that are super fun or have a lighter workload? i’m burned out lol

Select an option: 
	0. Quit
	1. Show post author
	2. Check for comments
	3. Show next post
	4. Select a subreddit
0

Process finished with exit code 0
```

### Transcript 2 (Problem 3)

_Paste in the transcript excerpts showing proper handling of the 7
errors (1, 2a, 2b, 2c, 2d, 3a, and 3b), labeling each._

```
// 1
// I edited credentials so they were incorrect.

Error: masecla.reddit4j.exceptions.AuthenticationException: Unauthorized! Invalid clientId or clientSecret! 
 Terminating program. Goodbye!

Process finished with exit code 1
```

```
// 2A, 2B, 2C, 2D

Hello, douglasconrad1.
Select an option: 
	0. Quit
	1. Select a subreddit

Invalid input, try again:
Select an option: 
	0. Quit
	1. Select a subreddit
a
Invalid input, try again:
Select an option: 
	0. Quit
	1. Select a subreddit
3
Input not in options, try again by inputting an available option:
Select an option: 
	0. Quit
	1. Select a subreddit
1
What subreddit would you like to select? 
pojnihbjyghtg
Invalid input, try again:
Select an option: 
	0. Quit
	1. Select a subreddit
0

Process finished with exit code 0

```

```
// 3A

Error: java.net.UnknownHostException: www.reddit.com 
Terminating program. Goodbye!

Process finished with exit code 1
```

```
// 3B

Hello, douglasconrad1.
Select an option: 
	0. Quit
	1. Select a subreddit
1
What subreddit would you like to select? 
dogs
Connection Error
Select an option: 
	0. Quit
	1. Try again
	2. Select a subreddit
0
Goodbye.

Process finished with exit code 0

```

### Transcript 3 (Problem 4)

_Paste in the transcript showing your additions to display comments._

```
/Users/dougconrad/Library/Java/JavaVirtualMachines/corretto-21.0.4/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=65085:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/dougconrad/IdeaProjects/Fundies1-Homework11/build/classes/kotlin/main:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.7.21/5407c3593c58860cec5ee3f66c468396b42f4c2b/kotlin-stdlib-jdk8-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/com.github.masecla22/Reddit4J/2fb38684f6/c2bfbb68289278fe640500f89068b0c8e5cf1b82/Reddit4J-2fb38684f6.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.7.21/a0ba09615c2213d580315e234b3febfea25b757e/kotlin-stdlib-jdk7-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.7.21/1a2eaf898a0dda83037034b10a42053cf8a7caf8/kotlin-stdlib-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jsoup/jsoup/1.16.1/ae551410a16433984cd4a8603622fafa9d8299f0/jsoup-1.16.1.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/com.google.code.gson/gson/2.10.1/b3add478d4382b78ea20b1671390a858002feb6c/gson-2.10.1.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.7.21/cb02257de8e13e8498f8e2f69f742f2d438e794d/kotlin-stdlib-common-1.7.21.jar:/Users/dougconrad/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar ClientKt
Hello, douglasconrad1.
Select an option: 
	0. Quit
	1. Select a subreddit
1
What subreddit would you like to select? 
dogs
You are now in dogs.
There are 27 posts.
Select an option: 
	0. Quit
	1. Show first post
	2. Select a subreddit
1
[WEEKLY VENT]DECEMBER 02-06, 2024

Is someone not picking up poop in front of your house? Is there an off leash dog in your neighborhood with a clueless owner? Did someone bring an out of control dog to the off-leash park? Is your neighbor walking uncomfortably close to you with an untrained dog? Here is where you can dump out your feelings and frustrations about these or whatever other topics you wish!

Just as a friendly reminder, the same rules regarding conduct in the general sub apply here as well.

Select an option: 
	0. Quit
	1. Show post author
	2. Check for comments
	3. Show next post
	4. Select a subreddit
2
There is one comment for this post.
Select an option: 
	0. Quit
	1. Show first comment
	2. Show post author
	3. Show next post
	4. Select a subreddit
1
Comment: RedditComment(name=t1_m02vuaw, approvedBy=null, author=iTalk2Pineapples, authorFlairCssClass=null, authorFlairText=null, bannedBy=null, body=I'm tired of all these megathreads. So many megathreads the entire front page is mostly megathreads. At this point we've been spammed with so many megathreads that we need a megathread to compile them all in one place., bodyHtml=&lt;div class="md"&gt;&lt;p&gt;I&amp;#39;m tired of all these megathreads. So many megathreads the entire front page is mostly megathreads. At this point we&amp;#39;ve been spammed with so many megathreads that we need a megathread to compile them all in one place.&lt;/p&gt;
&lt;/div&gt;, edited=false, gilded=0, likes=false, linkAuthor=null, linkId=t3_1h4uf20, linkTitle=null, linkUrl=null, numReports=0, parentId=t3_1h4uf20, replies=RedditData(kind=Listing, data=masecla.reddit4j.objects.RedditListing@1e4f4a5c), saved=false, score=5, scoreHidden=false, subreddit=dogs, subredditId=t5_2qhhk, distinguished=null, ups=5, downs=0, liked=null, created=1733166859, createdUtc=1733166859)
Select an option: 
	0. Quit
	1. Show comment author
	2. Show post again
	3. Show next post
	4. Select a subreddit
1
Comment Author: iTalk2Pineapples
Select an option: 
	0. Quit
	1. Show post again
	2. Show next post
	3. Select a subreddit
0
Goodbye.

Process finished with exit code 0

```

## Logistics

### Did you successfully implement everything that was requested?

_Answer "Yes", or state here which parts did not work or which tests did not
pass._ [1 point]

Yes, I implemented everything that was requested.

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]

About 2.5 hours

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours. We especially
like hearing about helpful TAs._ [1 point]

I worked with Ricardo de Guzman as a pair programmer. I did not attend any office hours.

### What was your AI usage?

_State explicitly (yes or no) whether you used AI. If so, say which tools you
used and what your prompts were. Your assignment will not be graded if you do
not answer this question._ [1 point]

I did not use any AI.

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which
ones were particularly helpful._ [1 points]

I used the Kotlin library and slides from class.

## Reddit

_Answer one or more of the following questions with at least one paragraph:_ [5 points]

* What additions might you make if that were a requirement for this assignment?
* If you use Reddit, are there any features you'd like added to a reader?
* Have you programmed to an API before? What APIs might you enjoy programming
  to in the future? See [The Top 50 Most Popular APIs](https://rapidapi.com/blog/most-popular-api/).
* What do you think about the [2023 Reddit API controversy](https://en.wikipedia.org/wiki/2023_Reddit_API_controversy)?

An addition I would make if that were a requirement for this assignment is I would include the option
of going to the most popular subreddit for ease of access. This is applicable and would be fun to code.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

_Constructive and actionable suggestions for improving assignments, office
hours, and lecture are always welcome._ [5 points]
The most difficult part of the assignment was finding and catching all the errors. The most rewarding
part of the assignment was the satisfaction after catching an error. I learned more about the
try and catch function and scope functions in this assignment.
