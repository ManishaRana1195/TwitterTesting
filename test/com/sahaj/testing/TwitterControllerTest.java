package com.sahaj.testing;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by rbansal on 03/07/15.
 */
public class TwitterControllerTest {
    Twitter Twitter;
    Tweet t1, t2;
    TwitterController controller;

    @Before
    public void setUp() throws Exception {
        //Real objects used for Collaborator
        t1 = new Tweet("rohiban", "First Tweet");
        t2 = new Tweet("kirang", "Second Tweet");
        //Mock object used for Collaborator
        Twitter = mock(Twitter.class);
        //SUT
        controller = new TwitterController(Twitter);
    }

    @Test
    public void shouldReadFeedFromTwitterAndTransformThem() {
        // stub the call to readFeed() to return what we want
        when(Twitter.readFeed())
                .thenReturn("@rohiban First Tweet|@kirang Second Tweet");

        List<Tweet> returnedTweets = controller.readFeed();

        // state testing
        assertEquals(asList(t1, t2), returnedTweets);
    }

    @Test
    public void shouldPostToTwitterAndReturnSuccessStatusWhenPostIsSuccessful() {
        String message = "Using Mockito is amazingly simple, once you get the dependencies right!";
        when(Twitter.post(any(String.class))).thenReturn(true);

        boolean posted = controller.post(message);

        assertTrue(posted);
        verify(Twitter).post(message);
    }

    @Test
    public void shouldReturnFailedStatusWhenPostIsUnsuccessful() {
        String message = "Using Mockito is amazingly simple, once you get the dependencies right!";
        when(Twitter.post(any(String.class))).thenReturn(false);

        boolean posted = controller.post(message);

        assertFalse(posted);
    }
}
