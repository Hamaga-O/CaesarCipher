public class MonoAlphaSubstitution extends Substitution{

  
   public String key;
   public static int keyLength;
   public char[] separatedKey;
   public static char[][] keyArray;
   
   public void setKey(String input){
       this.key = input;
   }   
   public static char[] createArray(String key){
       int i,j,count = 0; 
        count=key.length();
        keyLength = count/2;
       char [] separatedKey = new char [count];
       for (i = 0; i<count; i++){
       separatedKey[i] = key.charAt(i) ;
       }
       //create2DArray(separatedKey);
       
   return separatedKey;    
   }
  public static char[][] create2DArray(char[] sK){
      int j,count = 0;
      int i = 1;
      int f = 0;
      count = sK.length/2;
      char [][] keyArray = new char[count][2];  
       for (j = 0; j< count ; j++){
            for (i= 0; i < 2; i++){ 
            keyArray[j][i] = sK[f];
            f += 1;
            
            }
       }
               
    return keyArray;
   }
   public String encrypt(){
       return " ";
       
   }
   
   public String encrypt(String plaintext){
      int i = 0;
      int count = 0;
      String message = "";
      
      count = plaintext.length();
       char[] nFold = new char[count];
       for (i = 0;i < plaintext.length();i++){
      
          nFold[i] = encrypt(plaintext.charAt(i));
          
     
          message = message + nFold[i];
       }
            
       
        
       return message;
   } 
   public char encrypt(char c){
       int i,j = 0;
       char n = c;
       
       for( j = 0; j < keyLength; j++){
            if (n == keyArray [j][0]){
                
                n = keyArray[j][1];
                break;
            } 
       }
    return n;   
   }
   public String decrypt(String ciphertext){
      int i = 0;
      int count = 0;
      String message = "";
      
      count = ciphertext.length();
      char[] nFold = new char[count];
      
      for (i = 0;i < ciphertext.length();i++){
          nFold[i] = decrypt(ciphertext.charAt(i));
          message = message + nFold[i];
       }
       
       return message;
   }
   public char decrypt(char c){
       int i,j = 0;
       char n = c;
       
       for( j = 0; j < keyLength; j++){
            if (n == keyArray [j][1]){
                n = keyArray[j][0];
                break;
            } 
       }
    return n;   
   }



public static void main(String[] args){
    int i,j,n,count = 0;
    
      if (args.length < 3){
                System.out.println("Too few parameters!");
                System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
              
        }
        
        else if (args.length > 3){
                System.out.println("Too many parameters!");
                System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
              
        }
        
        else if (args[0].equals("encrypt")){
            
            MonoAlphaSubstitution code = new MonoAlphaSubstitution();
            code.key = args[1];
            code.separatedKey = createArray(code.key);
            code.keyArray = create2DArray(code.separatedKey);
            
            System.out.println(code.encrypt(args[2]));
        }
            
        else if (args[0].equals("decrypt")){
            
            MonoAlphaSubstitution code = new MonoAlphaSubstitution();
            code.key = args[1];
            code.separatedKey = createArray(code.key);
            code.keyArray = create2DArray(code.separatedKey);
            
            System.out.println(code.decrypt(args[2]));
        }    
             
        else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        }
        
        

}