public class Caesar extends MonoAlphaSubstitution {
    private static int shift;
    public static char[] createArray(String key){
       int i,j,count = 0; 
        count=key.length();
        keyLength = count;
       char [] separatedKey = new char [count];
       for (i = 0; i<count; i++){
       separatedKey[i] = key.charAt(i) ;
       }
       //create2DArray(separatedKey);
       
   return separatedKey;    
   }
   
   /* public static char[][] create2DArray(char[] sK){
      int j,count = 0;
      int i = 1;
      int f = 0;
      count = sK.length;
      String specChar = "!£$%^&*()¬`@'~#?/:;{}[]|\"\\><.,-_+=1234567890";
      char [][] keyArray = new char[count][2];  
       for (j = 0; j< count ; j++){
           int char1 = sK[f];
           char char2;
            for (i= 0; i < 2; i++){ 
            if (specChar.indexOf(sK[f]) != -1){
            keyArray[j][i] = sK[f];
            if (i > 0){    
            char1 += shiftInt;
            char2 = (char)char1;
               }
            }
            else {
                keyArray[j][0] = sK[f];
                keyArray[j][1] = sK[f];
                }
            f += 1;
            }
       }           
    return keyArray;
    
    }*/
    
    
    
    public String encrypt(){
     return "";
    }
    
    public void getShift(int shift){
        this.shift = shift;
    } 
    
    public String encrypt(String plaintext){
       int i,j,count = 0; 
       int keyLength = 0;
       String specChar = "!£$%^&*()¬`@\'~#?/:;{}[]|\"\\><.,-_+=1234567890";
       String nFold = "";
       
       count = plaintext.length();
       keyLength = count;
       
       char [] separatedKey = new char [count];
       
       for (i = 0; i < count; i++){
       separatedKey[i] = plaintext.charAt(i);
       }
       
       for (j = 0; j < count ; j++){
           int char1 = separatedKey[j];
           char char2;
           
           shift = shift % 26;
            
            if (specChar.indexOf(separatedKey[j]) == -1){
                              
                if (char1 >= 65 && char1 <= 90){
                char1 = (((char1 + shift)-65)%26)+65;  
                }
               
                else if (char1 >= 97 && char1 <= 122){
                 char1 = (((char1 + shift)-97)%26)+97; 
                }
              
              
                //char1 += shiftInt;
                char2 = (char)char1;
                separatedKey[j] = char2;
            }

       }
       for (i = 0; i < separatedKey.length; i++){
           if (separatedKey[i] == '#'){
           nFold = nFold + " ";
           }
           else{
           nFold = nFold + separatedKey[i];
           }
       }
       
     return nFold;     
               
    }
    
    public String decrypt(){
        return "";
        
    }
    
    public String decrypt(String ciphertext){
         int i,j,count = 0; 
       int keyLength = 0;
       String specChar = "!£$%^&*()¬`@\'~#?/:;{}[]|\"\\><.,-_+=1234567890";
       String nFold = "";
       
       count = ciphertext.length();
       keyLength = count;
       
       char [] separatedKey = new char [count];
       
       for (i = 0; i < count; i++){
       separatedKey[i] = ciphertext.charAt(i);
       }
       
       for (j = 0; j < count ; j++){
           int char1 = separatedKey[j];
           char char2;
           
           shift = shift % 26;
            
            if (specChar.indexOf(separatedKey[j]) == -1){
                              
                if (char1 >= 65 && char1 <= 90){
                    if ((char1 - shift) < 65) {
                        char1 = (char1 - shift) + 26;
                        
                    }
                    else{
                char1 = (((char1 - shift)-65)%26)+65;  
                }
                }
                else if (char1 >= 97 && char1 <= 122){
                    if ((char1 - shift) < 97){ 
                        char1 = (char1 - shift) + 26;
                    }
                    else{
                 char1 = (Math.abs(((char1 - shift)-97))%26+97); 
                }
                }
              
              
                //char1 += shiftInt;
                char2 = (char)char1;
                separatedKey[j] = char2;
            }

       }
       for (i = 0; i < separatedKey.length; i++){
           if (separatedKey[i] == '#'){
           nFold = nFold + " ";
           }
           else{
           nFold = nFold + separatedKey[i];
           }
       }
       
     return nFold;     
               
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args){
    int i,j,n,count = 0;
    
      if (args.length < 3){
                System.out.println("Too few parameters!");
                System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
              
        }
        
        else if (args.length > 3){
                System.out.println("Too many parameters!");
                System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
              
        }
        
        else if (args[0].equals("encrypt")){
            
            Caesar code = new Caesar();
            code.getShift(Integer.parseInt(args[1]));
            
            System.out.println(code.encrypt(args[2]));
        }
            
        else if (args[0].equals("decrypt")){
            
            Caesar code = new Caesar();
            code.getShift(Integer.parseInt(args[1]));

            
            System.out.println(code.decrypt(args[2]));
        }    
             
        else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt n \"cipher text\"");
        }
        }
        
}
