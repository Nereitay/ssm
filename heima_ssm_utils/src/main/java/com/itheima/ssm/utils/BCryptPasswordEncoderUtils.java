package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

   /* public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);
        System.out.println(pwd); //$2a$10$J9sJpgipssZhUgXoYHD/KeARPz52x8aph7zYzpkab4x4ywjYtcxr6
        System.out.println(pwd.length()); //60
    }*/
}
