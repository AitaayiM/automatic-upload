package project;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class Cryptor {

    public static String getEnrypt(String inputPass , String inputSalt, String inputText){
        try{
            byte[] iv= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            IvParameterSpec ivParameter= new IvParameterSpec(iv);
            SecretKeyFactory secretKeyFactory= SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec= new PBEKeySpec(inputPass.toCharArray(), inputSalt.getBytes(), 65536, 256);
            SecretKey secretKey= secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec= new SecretKeySpec(secretKey.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameter);

            return Base64.getEncoder().encodeToString(inputText.getBytes("UTF-8"));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public String getDecrypt(String inputPass , String inputSalt, String inputText){
        String falsE="";
        try {
            byte[] iv= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            IvParameterSpec ivParameter= new IvParameterSpec(iv);
            SecretKeyFactory secretKeyFactory= SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec= new PBEKeySpec(inputPass.toCharArray(), inputSalt.getBytes(), 65536, 256);
            SecretKey secretKey= secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec= new SecretKeySpec(secretKey.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameter);

            return new String(cipher.doFinal(Base64.getDecoder().decode(inputText)));
            
        } catch (Exception e) {
            return falsE;
        }
    }
}
