package com.imodupsy.sanitytest.premier;

/**
 * @author iModupsy
 * @created 14/02/2022
 */

@FunctionalInterface  // Contains only one abstract method. It can only have one method to exhibit
public interface Scoreable {

    int getScore();
}
