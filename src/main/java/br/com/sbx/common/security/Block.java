package br.com.sbx.common.security;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * This class make Blockchain hash values    
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class Block {
	/**
	 * 
	 */
    private final String previousHash;
    
    /**
     * 
     */
    private final String data;
    
    /**
     * 
     */
    private final String hash;
    
    /**
     * 
     */
    private long nonce;
    
    /**
     * 
     */
    private final LocalDateTime timestamp;
   
    /**
     * 
     * @param previousHash
     * @param difficulty
     * @param values
     */
    public Block(String previousHash, String... values) {
    	this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
    	this.previousHash = previousHash;
        this.data = String.join(",", values);
        this.hash = calculateHash();
    }
    
    /**
     * 
     * @return
     */
    private String calculateHash() {
        try {
        	String input = previousHash + data + nonce;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 
     * @param difficulty
     * @return
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
    }
    
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getNonce() {
        return nonce;
    }

    public void incrementNonce() {
        nonce++;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    
    @Override
    public String toString() {
        return "Block{" +
                "previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
