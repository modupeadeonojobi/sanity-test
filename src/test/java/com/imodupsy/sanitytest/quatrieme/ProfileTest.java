package com.imodupsy.sanitytest.quatrieme;


//import com.imodupsy.sanitytest.second.Criterion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

       boolean result = profile.matches();
       assertFalse(result);

    }





}