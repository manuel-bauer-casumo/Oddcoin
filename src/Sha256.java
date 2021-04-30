
import java.security.*;

public class Sha256 {
    public static String hash256(String data) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return bytesToHex(md.digest());

        } catch (NoSuchAlgorithmException e) {
            // We don't give a shit
            // please don't do that in production... 
        }
        return "nope";
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}