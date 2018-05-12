package am.ak.mybatis.util;

public enum HashAlgorithm {

    MD2     (1, 16, "MD2"),
    MD5     (2, 16, "MD5"),
    SHA1    (3, 20, "SHA-1"),
    SHA256  (4, 32, "SHA-256"),
    SHA384  (5, 64, "SHA-384"),
    SHA512  (6, 64, "SHA-512");

    private final int value;

    private final String label;

    private final int size;

    HashAlgorithm(int value, int size, String label) {
        this.value = value;
        this.label = label;
        this.size = size;
    }

    public static HashAlgorithm valueOf(final int value) {
        for (HashAlgorithm e : HashAlgorithm.values())
            if (e.value == value)
                return e;
        return null;
    }

    public static HashAlgorithm labelOf(final String label) {
        for (HashAlgorithm e : HashAlgorithm.values()) {
            if (e.label.equalsIgnoreCase(label)) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public int getSize() {
        return size;
    }
}
