package com.imodupsy.sanitytest.troisieme.util;

import java.io.IOException;

/**
 * @author iModupsy
 * @created 20/02/2022
 */
public interface Http {
    String get(String url) throws IOException;
}
