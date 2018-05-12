package am.gevor.game.util;

public class Converter {

    private static final String ALPHANUMERIC = "0123456789abcdef";

    public static synchronized String toHexString(byte[] bytes) {
        return toHexString(bytes, 0, bytes.length, false);
    }

    public static synchronized String toHexString(byte[] bytes, int offset, int countOfBytes) {
        return toHexString(bytes, offset, countOfBytes, false);
    }

    public static synchronized String toHexString(byte[] bytes, int offset, int countOfBytes, boolean isUpperCase) {

        if (offset + countOfBytes > bytes.length) {
            throw new RuntimeException("Invalid argument [data length:" + bytes.length
                    + ", offset:" + offset + ", count:" + countOfBytes + "]");
        }

        String chars = isUpperCase ? ALPHANUMERIC.toUpperCase() : ALPHANUMERIC;
        StringBuffer buffer = new StringBuffer(bytes.length * 2);

        for (int i = offset; i < offset + countOfBytes; i++) {
            buffer.append(chars.charAt((bytes[i] & 0xF0) >> 4))
                  .append(chars.charAt(bytes[i] & 0x0F));
        }
        return buffer.toString();
    }

    public static synchronized byte[] hexToBytes(String source) {

        byte[] res = new byte[source.length() / 2];
        for (int i = 0; i < source.length() - 1; i += 2) {
            short tmp = Short.parseShort(source.substring(i, i + 2), 16);
            res[i / 2] = (tmp > 127) ? (byte) (tmp - 256) : (byte) tmp;
        }
        return res;
    }

    public static synchronized byte[] toBytes(String source) {
        byte[] res = new byte[source.length()];
        for (int i = 0; i < source.length(); i++) {
            res[i] = (byte) source.charAt(i);
        }
        return res;
    }

    public static synchronized String toString(byte[] bts) {
        StringBuffer chs = new StringBuffer(bts.length);
        for (int i = 0; i < bts.length; i++) {
            chs.append((char) bts[i]);
        }
        return chs.toString();
    }
}
