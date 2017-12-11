package com.cherry.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The library to check following pooints
 * 1. password to bcrypt hash string.
 * 2. password with hash string compare.
 *
 * Created by kumar on 11/12/17.
 */
public class Bcrypt {

    public static void main(String args[]){
        if(args.length <= 0){
            System.out.println("===== Argument is empty =====");
            System.out.println("===== 1. OPTION ==> java -jar *.jar {password-string} =====");
            System.out.println("===== 2. OPTION ==> java -jar *.jar {password-string} {hash-password-string} =====");

        }else if(args.length == 1){
            final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            final String hashedPassword = passwordEncoder.encode(args[0]);

            System.out.println("===== Password String => "+args[0]+" ===== AND hashed Password ==> "+ hashedPassword);

        }else if(args.length == 2){
            System.out.println("===== Password String => "+args[0]);
            System.out.println(" ===== Hashed Password String ==> "+ args[1]);

            final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            final String hashedPassword = passwordEncoder.encode(args[0]);
            final Boolean validation=passwordEncoder.matches(args[0],hashedPassword);
            if(validation){
                System.out.println("========= PASSWORD MATCH GOOD HASH =========");
            }else{
                System.err.println("========= NOT MATCH BAD HASH =========");
            }


        }

    }
}
