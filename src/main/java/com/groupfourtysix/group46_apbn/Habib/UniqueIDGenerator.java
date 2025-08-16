package com.groupfourtysix.group46_apbn.Habib;

import java.util.UUID;

public class UniqueIDGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

//    public static void main(String[] args) {
//        System.out.println("Unique ID: " + generateId());
//    }
}

