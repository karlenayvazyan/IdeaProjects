package am.gevor.game.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtils {

    public static String hashMessage(HashAlgorithm hashAlgorithm, String message)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if (hashAlgorithm == null) {
            return null;
        }
        return Converter.toHexString(hashMessageBytes(hashAlgorithm, message));
    }

    public static byte[] hashMessageBytes(HashAlgorithm algorithm, String message)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return hashMessageBytes(algorithm, Converter.toBytes(message));
    }

    public static byte[] hashMessageBytes(HashAlgorithm algorithm, byte[] dataToHash)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getLabel());
            messageDigest.update(dataToHash);
            return messageDigest.digest();
        } catch (Exception e) {
            throw new RuntimeException("Failed to make hash data", e);
        }
    }
}
