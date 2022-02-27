package com.imodupsy.sanitytest.quatrieme;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author iModupsy
 * @created 27/02/2022
 */
class ProfileTest {

    
    @Test
    public void matchesNothingWhenProfileEmpty() {
       Profile profile = new Profile();
       Question question = new BooleanQuestion(1, "Paid vacation?");
       Criterion criterion = new Criterion(new Answer(question, Bool.True), Weight.DontCare);

       boolean result = profile.matches(criterion);
       assertFalse(result);

    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer() {
        Profile profile = new Profile();
        Question question = new BooleanQuestion(1, "Paid vacation?");
        Answer answer = new Answer(question, Bool.True);
        profile.add(answer);
        Criterion criterion = new Criterion(answer, Weight.Important);

        boolean result = profile.matches(criterion);
        assertTrue(result);
    }





}