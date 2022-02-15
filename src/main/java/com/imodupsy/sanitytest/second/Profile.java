package com.imodupsy.sanitytest.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iModupsy
 * @created 15/02/2022
 */
public class Profile {

    private Map<String, Answer> answerMap = new HashMap<>();

    private int score;

    private String name;

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Answer answer) {
        answerMap.put(answer.getQuestionText(), answer);
    }

    public boolean matched(Criteria criteria) {
        score = 0;

        boolean kill = false;
        boolean anyMatches = false;
        for (Criterion criterion : criteria) {
            Answer answer = answerMap.get(criterion.getAnswer().getQuestionText());
            boolean match = criterion.getWeight() == Weight.DontCare || answer.match(criterion.getAnswer());

            if (!match && criterion.getWeight() == Weight.MustMatch) {
                kill = true;
            }
            if (match) {
                score += criterion.getWeight().getValue();
            }
            anyMatches |= match;

        }
        if (kill)
            return false;
        return anyMatches;
    }

    public int score() {
        return score;
    }

}

