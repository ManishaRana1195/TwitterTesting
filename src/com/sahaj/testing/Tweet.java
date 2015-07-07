package com.sahaj.testing;

/**
 * Created by rbansal on 01/07/15.
 */
public class Tweet {
    String origin;
    String theTweet;

    public Tweet(String originHandle, String t) {
        this.origin = originHandle;
        this.theTweet = t;
    }

    public String whoTweeted() {
        return this.origin;
    }

    public String getTweet() {
        return this.theTweet;
    }

    public boolean isReTweet() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tweet) {
            Tweet t = (Tweet) o;
            return (this.origin.equals(t.origin) && this.theTweet.equals(t.theTweet));
        }
        return false;
    }

    public String toString() {
        return "@" + this.origin + " " + this.theTweet + " ";
    }
}
