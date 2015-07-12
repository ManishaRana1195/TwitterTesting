package com.sahaj.testing;


import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by manisharana on 7/11/15.
 */

public class TweetTest {

    public Tweet tweet;

    @BeforeTest
    public void setUp() throws Exception {
        tweet = new Tweet("manishaR", "my dummy tweet");
    }

    @Test
    public void shouldReturnProperTweetOriginHandle() {

        assertEquals("manishaR", tweet.whoTweeted());
    }

    @Test
    public void shouldReturnProperTweet(){
        assertEquals("my dummy tweet" ,tweet.getTweet());
    }

    @Test
    public void shouldNotReturnOtherTweet(){
        assertNotEquals("xyz",tweet.getTweet());
    }

    @Test
    public void shouldNotReturnWrongOriginHandle(){
        assertNotEquals("rohitBan",tweet.whoTweeted());
    }


}