package com.imodupsy.sanitytest.troisieme;

import com.imodupsy.sanitytest.troisieme.util.Http;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

/**
 * @author iModupsy
 * @created 20/02/2022
 */

@ExtendWith(MockitoExtension.class)
class AddressRetrieverTest {

    @Mock
    private Http http;

    @InjectMocks
    private AddressRetriever addressRetriever;

    @Test
    public void answersAppropriateAddressForValidCoordinates() throws IOException, ParseException {

        when(http.get(contains("lat=38.000000&lon=-104.000000"))).thenReturn(
                "{\"address\":{"
                + "\"house_number\":\"324\","
                + "\"road\":\"North Tejon Street\","
                + "\"city\":\"Colorado Springs\","
                + "\"state\":\"Colorado\","
                + "\"postcode\":\"80903\","
                + "\"country_code\":\"us\"}"
                + "}");


        Address address = addressRetriever.retrieve(38.0, -104.0);

        assertThat(address.houseNumber, equalTo("324"));

    }



}