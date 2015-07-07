package com.sahaj.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbansal on 01/07/15.
 */

public class TwitterController {
    Twitter twitter;

    public TwitterController(Twitter Twitter) {
        this.twitter = Twitter;
    }

    public List<Tweet> readFeed() {
        return transformFeed(twitter.readFeed());
    }

    protected List<Tweet> transformFeed(String feed) {
        String twitterFeed = feed;
        List<Tweet> tweets = new ArrayList<Tweet>();

        // transformation implementation to create a list of Tweets
        do {
            int i = twitterFeed.indexOf("|");
            String t = "";

            if (i > 0) {
                t = twitterFeed.substring(0, i);
                twitterFeed = twitterFeed.substring(i + 1, twitterFeed.length());
            } else {
                t = twitterFeed;
                twitterFeed = "";
            }

            int j = t.indexOf(" ");
            tweets.add(new Tweet(t.substring(1, j).trim(), t.substring(j + 1, t.length()).trim()));

        } while (twitterFeed.contains("@"));

        return tweets;
    }

    public boolean post(String message) {
        return twitter.post(message);
    }
}
