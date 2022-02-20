package com.imodupsy.sanitytest.troisieme;

import java.io.*;

import com.imodupsy.sanitytest.troisieme.util.Http;
import com.imodupsy.sanitytest.troisieme.util.HttpImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * @author iModupsy
 * @created 20/02/2022
 */

@RequiredArgsConstructor
public class AddressRetriever {

    private final HttpImpl httpImpl;



    public Address retrieve (double latitude, double longitude) throws IOException, ParseException {

        String params = String.format("lat=%.6flon=%.6f", latitude, longitude);
        String response = httpImpl.get("http://open.mapquestapi.com/nominatim/v1/reverse?format=json&" + params);

        JSONObject obj = (JSONObject)new JSONParser().parse(response);
        JSONObject address = (JSONObject)obj.get("address");
        String country = (String)address.get("country_code");
        if (!country.equals("us")) {
            throw new UnsupportedOperationException("cannot support non-US addresses at this time");
        }

        String houseNumber = (String)address.get("house_number");
        String road = (String)address.get("road");
        String city = (String)address.get("city");
        String state = (String)address.get("state");
        String zip = (String)address.get("postcode");
        return new Address(houseNumber, road, city, state, zip);
    }
}
