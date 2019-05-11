package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    
    public static String md5(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digest = md.digest(senha.getBytes("utf-8"));

        StringBuilder sb = new StringBuilder();
        for(byte b: digest){
          sb.append(String.format("%02x", 0xFF & b));
        }
        
        String senhaHex = sb.toString();
        
        return senhaHex;
    }
}
