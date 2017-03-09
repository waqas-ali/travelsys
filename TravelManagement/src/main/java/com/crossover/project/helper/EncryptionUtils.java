/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.helper;

import java.security.MessageDigest;

/**
 *
 * @author waqas.ali2
 */
public class EncryptionUtils {

    public static String convertStringToMD5Hash(String string) {
        byte[] hash;
        StringBuilder hex = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));

            hex = new StringBuilder(hash.length * 2);

            for (byte b : hash) {
                int i = (b & 0xFF);
                if (i < 0x10) {
                    hex.append('0');
                }
                hex.append(Integer.toHexString(i));
            }
        } catch (Exception e) {

        }
        return hex.toString();
    }

}
