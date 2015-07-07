package com.sahaj.testing;

import com.sahaj.testing.Tweet;
import junit.framework.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created by rbansal on 03/07/15.
 */
public class TweetTesting {
    protected String username;

    @Before
    public void setUp() throws Exception {
        this.username = "rohiban";
    }

    @Test
    public void testTweet() {
        String t = "i want to say tweet, tweet, tweet, ...";
        Tweet myTweet = new Tweet(this.username, t);

        assertEquals(this.username, myTweet.whoTweeted());
        assertEquals(t, myTweet.getTweet());
    }
}
