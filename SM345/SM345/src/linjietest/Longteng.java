import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
//import org.apache.commons.codec.binary.Hex;
//import org.apache.commons.codec.binary.Base64;

public class Longteng {

    public static void main(String[] args) {
        try {

            String json = "{\"name\":\"Marydon\",\"website\":\"http://www.cnblogs.com/Marydon20170307\"}";
            json = "1234567890中华人民共和国abcdefghijklmnopqrstuvwxyz";
            System.out.println("国密SM4加密解密：");
            // 自定义的32位16进制密钥
//            String key = "86C63180C2806ED1F47B859DE501215B";
            String key = "1234567890123456";
            String cipher = Sm4Util.encryptEcb(key, json);
            System.out.println("国密SM4加密解密：\r\n密钥：" + key + " \n加密内容：" + json + " \n加密后v" + cipher);

            //System.out.println(cipher);//c7JUMyMa7R4pE7xAztUy6I9rQhu6rr8bqerB1pX3ZbhZEVNIrw86Jr8sQuqT5VJLkOc2X6couGoPTzM7MJTnVg
            //比对加密解密信息
            System.out.println(Sm4Util.verifyEcb(key, cipher, json));// true
            json = Sm4Util.decryptEcb(key, cipher);
            System.out.println("国密SM4加密解密：\n密钥：" + key + " \n加密内容：" + cipher + " \n解密后：" + json);

            //System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


