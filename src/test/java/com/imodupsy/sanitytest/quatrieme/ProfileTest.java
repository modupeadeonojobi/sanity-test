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

    private Profile profile;

    private BooleanQuestion questionIsTherePaidVacation;

    private Answer answerThereIsPaidVacation;

    @BeforeEach
    public void createProfile() {
        profile = new Profile();

    }

    @BeforeEach
    public void createQuestionAndAnswer() {
        questionIsTherePaidVacation = new BooleanQuestion(1, "Paid vacation?");
        answerThereIsPaidVacation = new Answer(questionIsTherePaidVacation, Bool.True);

    }

    @Test
    public void matchesNothingWhenProfileEmpty() {
       Criterion criterion = new Criterion(answerThereIsPaidVacation, Weight.DontCare);

       boolean result = profile.matches(criterion);
       assertFalse(result);

    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer() {
        profile.add(answerThereIsPaidVacation);
        Criterion criterion = new Criterion(answerThereIsPaidVacation, Weight.Important);

        boolean result = profile.matches(criterion);
        assertTrue(result);

    }





}