package com.imodupsy.sanitytest.premier;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * @author iModupsy
 * @created 14/02/2022
 */
class ScoreCollectionTest {


    @Test
    void answersArithmeticMeanOfTwoNumbers() {

        // Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // Act
        int actualResult = collection.arithmeticMean();

        // Assert
        assertThat(actualResult, equalTo(6));

    }
}