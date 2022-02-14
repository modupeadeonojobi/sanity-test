package com.imodupsy.sanitytest.premier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iModupsy
 * @created 14/02/2022
 */
public class ScoreCollection {

    private List<Scoreable> scoreList = new ArrayList<>();

    public void add (Scoreable scoreable) {
        scoreList.add(scoreable);
    }

    public int arithmeticMean() {
        int total = scoreList.stream().mapToInt(Scoreable::getScore).sum();
        return total /scoreList.size();
    }
}
