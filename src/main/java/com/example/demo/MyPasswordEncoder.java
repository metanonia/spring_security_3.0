package com.example.demo;

import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        // return this.getSHA512Pw(rawPassword);
        log.info("Passwod encode = " + rawPassword.toString());
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // if (rawPassword == null) {
        //     throw new IllegalArgumentException("rawPassword cannot be null");
        // }
        // if (encodedPassword == null || encodedPassword.length() == 0) {
        //     return false;
        // }

        // String encodedRawPw = this.getSHA512Pw(rawPassword);
        // return encodedRawPw.equals(encodedPassword);
        log.info("passwd matches = " + rawPassword.toString() + " : " + encodedPassword);
        return rawPassword.toString().matches(encodedPassword);
    }
    
    private String getSHA512Pw(CharSequence rawPassword) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(rawPassword.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] msgb = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msgb.length; i++) {
            String tmp = Integer.toHexString(msgb[i] & 0xFF);
            while (tmp.length() < 2)
                tmp = "0" + tmp;
            sb.append(tmp.substring(tmp.length() - 2));
        }
        return sb.toString();
    }
}
