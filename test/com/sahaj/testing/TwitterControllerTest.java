package com.sahaj.testing;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyList;

/**
 * Created by manisharana on 7/11/15.
 */

public class TwitterControllerTest {


    private Twitter mock;
    private TwitterController twitterController;
    private Tweet tweet1;
    private Tweet tweet2;

    @BeforeTest
    public void setUp() throws Exception {
        mock = Mockito.mock(Twitter.class);
        twitterController = new TwitterController(mock);
        tweet1 = new Tweet("manishaR", "Dummy Tweet");
        tweet2 = new Tweet("shwetaT", "First Tweet");
    }

    @Test
    public void shouldReadFeedFromTwitter(){
        Mockito.stub(mock.readFeed()).toReturn("@manishaR Dummy Tweet|@shwetaT First Tweet");
        List<Tweet> tweetList = twitterController.readFeed();
        assertEquals(asList(tweet1,tweet2), tweetList );
    }

    @Test
    public void shouldPostMessageToTwitterAndReturnTrueIfSuccessful(){
        Mockito.stub(mock.post("some tweet")).toReturn(true);
        boolean post = twitterController.post("some tweet");
        assertEquals(true,post );
        Mockito.verify(mock).post("some tweet");
    }

    @Test
    public void shouldReturnFalseWhenPostIsUnsuccessful() {
        String message = "some tweet";
        Mockito.stub(mock.post(message)).toReturn(false);

        boolean posted = twitterController.post(message);

        assertFalse(posted);
    }

    @Test
    public void shouldTransformFeedStringIntoTweets(){


        String feeds = "@manishaR Dummy Tweet|@shwetaT First Tweet";
        assertEquals(asList(tweet1,tweet2), twitterController.transformFeed(feeds));
    }
}