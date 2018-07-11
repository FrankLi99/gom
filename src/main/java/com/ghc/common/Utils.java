package com.ghc.common;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
    public static String digestPassword(String password){

        return DigestUtils.md5Hex(password);
    }
}
