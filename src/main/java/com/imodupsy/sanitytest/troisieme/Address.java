package com.imodupsy.sanitytest.troisieme;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author iModupsy
 * @created 20/02/2022
 */

@Data
@ToString
@RequiredArgsConstructor
public class Address {

    public final String road;

    public final String city;

    public final String state;

    public final String zip;

    public final String houseNumber;

}
