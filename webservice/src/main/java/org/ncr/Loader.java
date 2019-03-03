package org.ncr;

import club.ncr.etl.TCMotorLoad;
import club.ncr.security.Crypto;
import org.apache.tomcat.util.security.MD5Encoder;

public class Loader {

    public static void main(String[] args) {
        new TCMotorLoad().execute();
    }
}
