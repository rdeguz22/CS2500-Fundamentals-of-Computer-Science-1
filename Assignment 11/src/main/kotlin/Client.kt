import masecla.reddit4j.client.Reddit4J
import masecla.reddit4j.client.UserAgentBuilder
import masecla.reddit4j.objects.RedditComment
import masecla.reddit4j.objects.RedditPost
import masecla.reddit4j.objects.subreddit.RedditSubreddit
import kotlin.system.exitProcess

// These are used for creating the user agent.
// You should change AUTHOR.
private const val APP_NAME = "Fundies Homework 11"
private const val AUTHOR = "REPLACE"
private const val VERSION = "0.1"

/**
 * A connection to the Reddit API for a specific user.
 */
object Connection {
    // Students don't need to worry about how these two statements work.
    private val userAgent = UserAgentBuilder().appname(APP_NAME).author(AUTHOR).version(VERSION).build()
    private val redditClient: Reddit4J = Reddit4J.rateLimited()

    init {
        redditClient.username = USERNAME
        redditClient.password = PASSWORD
        redditClient.clientId = CLIENT_ID
        redditClient.clientSecret = CLIENT_SECRET
        redditClient.setUserAgent(userAgent)
        redditClient.connect()
    }

    /**
     * This user's name (from their profile).
     */
    val userName: String
        get() = redditClient.selfProfile.name

    /**
     * Gets the subreddit named [subredditName].
     */
    fun getSubreddit(subredditName: String): RedditSubreddit {
        return redditClient.getSubreddit(subredditName)
    }

    /**
     * Gets posts from [subreddit].
     *
     * @return text posts that are marked as being acceptable
     * for people under 18
     */
    fun getPosts(subreddit: RedditSubreddit): List<RedditPost> =
        subreddit.hot.submit().filter { !it.isOver18 }.filter { it.selftext.isNotEmpty() }

    /**
     * Gets all comments for this [post].
     */
    fun getComments(post: RedditPost): List<RedditComment> {
        return redditClient.getCommentsForPost(post.subreddit, post.id).submit()
    }
}

/**
 * An option to present to the user.
 *
 * @property text a textual description
 * @property function the function to call if the option is selected
 */
class Option(val text: String, val function: () -> Unit) {
    companion object {
        /**
         * Offers the user [options] of what to do next. In addition to showing
         * the passed options, there is always an option numbered 0 to quit the
         * program and a final option to select a subreddit.
         */
        fun offerOptions(options: List<Option>) {
            val allOptions = listOf(
                Option("Quit", function = { exitProcess(0) })
            ) + options + listOf(
                Option("Select a subreddit", function = { selectSubreddit() })
            )
            println("Select an option: ")
            for (i in allOptions.indices) {
                println("\t$i. ${allOptions[i].text}")
            }
            val input = readln().toInt()
            allOptions[input].function()
        }

        private fun showPostAuthor(posts: List<RedditPost>, postNumber: Int) {
            println("Post author: ${posts[postNumber].author}")
            offerOptions(
                listOf(
                    Option("Show post again", function = { showPost(posts, postNumber) }),
                    Option("Check for comments", function = { checkForComments(posts, postNumber) }),
                    Option("Show next post", function = { showPost(posts, postNumber + 1) }),
                )
            )
        }

        private fun checkForComments(posts: List<RedditPost>, postNumber: Int) {
            val options = mutableListOf(
                Option("Show post author", function = { showPostAuthor(posts, postNumber) }),
                Option("Show next post", function = { showPost(posts, postNumber + 1) }),
            )
            val comments: List<RedditComment> = Connection.getComments(posts[postNumber])
            println(
                when (comments.size) {
                    0 -> "There are no comments for this post."
                    1 -> "There is one comment for this post."
                    else -> "There are ${comments.size} comments for this post."
                }
            )
            if (comments.isNotEmpty()) {
                options.add(0, Option("Show first comment", function = { showComment(posts, postNumber, comments, 0) }))
            }
            offerOptions(options)
        }

        private fun displayPost(post: RedditPost) {
            println(post.title.uppercase())
            println()
            println(post.selftext)
            println()
        }

        private fun showPost(posts: List<RedditPost>, postNumber: Int) {
            displayPost(posts[postNumber])
            offerOptions(
                listOf(
                    Option("Show post author", function = { showPostAuthor(posts, postNumber) }),
                    Option("Check for comments", function = { checkForComments(posts, postNumber) }),
                    Option("Show next post", function = { showPost(posts, postNumber + 1) }),
                )
            )
        }

        private fun showComment(
            posts: List<RedditPost>, postNumber: Int, comments: List<RedditComment>, commentNumber: Int
        ) {
            TODO("Student must write.")
        }

        private fun showCommentAuthor(
            posts: List<RedditPost>, postNumber: Int, comments: List<RedditComment>, commentNumber: Int
        ) {
            println("Comment Author: ${comments[commentNumber].author}")
            val options = mutableListOf<Option>(
                Option("Show post again", function = { showPost(posts, postNumber + 1) })
            )
            if (postNumber + 1 != posts.size) {
                options.add(Option("Show post again", function = { showPost(posts, postNumber + 1) }))
            }
        }

        private fun quit() {
            println("Goodbye.")
            exitProcess(0)
        }

        private fun selectSubreddit() {
            println("What subreddit would you like to select? ")
            val subredditName = readln()
            val subreddit: RedditSubreddit = Connection.getSubreddit(subredditName)
            println("You are now in ${subreddit.displayName}.")
            val posts = Connection.getPosts(subreddit)
            when (posts.size) {
                0 -> println("There are no posts.")
                1 -> println("There is one post.")
                else -> println("There are ${posts.size} posts.")
            }

            if (posts.isNotEmpty()) {
                offerOptions(
                    listOf(
                        Option("Show first post", function = { showPost(posts, 0) }),
                    )
                )
            }
        }
    }
}

fun main() {
    println("Hello, ${Connection.userName}.")
    Option.offerOptions(emptyList())
}
