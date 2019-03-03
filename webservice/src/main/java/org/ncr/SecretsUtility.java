package org.ncr;

import club.ncr.security.Crypto;
import org.apache.tomcat.util.security.MD5Encoder;

public class SecretsUtility {

    public static void main(String[] args) {
        System.out.println(new String(MD5Encoder.encode("iCTa!M]hr2F@FuN{".getBytes())));
        System.out.println(Crypto.encode("4oSNXLdcFGle"));
    }
}
