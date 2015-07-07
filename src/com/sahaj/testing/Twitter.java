package com.sahaj.testing;

/**
 * Created by rbansal on 07/07/15.
 */
public interface Twitter {
    String readFeed();

    boolean post(String message);
}
