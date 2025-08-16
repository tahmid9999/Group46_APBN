package com.groupfourtysix.group46_apbn;

import java.util.Random;

public class UniqueID {
    public static String generateID() {
        long timestamp = System.currentTimeMillis();
        int randomNum = new Random().nextInt(99999);
        return timestamp + "-" + randomNum;
    }
}
