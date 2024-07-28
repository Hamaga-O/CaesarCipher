public abstract class Substitution implements Cipher{
    public abstract char encrypt(char c);
    public abstract char decrypt(char c);
    
    public String encrypt(String plaintext){
        return plaintext;
        
    }
    public String decrypt(String ciphertext){
        return ciphertext;
    }
}