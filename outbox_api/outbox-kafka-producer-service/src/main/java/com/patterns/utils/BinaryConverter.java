package com.patterns.utils;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class BinaryConverter {

    public static UUID base64ToUUID(String base64String) {
        byte[] bytes = Base64.getDecoder().decode(base64String);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long mostSignificantBits = byteBuffer.getLong();
        long leastSignificantBits = byteBuffer.getLong();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }
}
