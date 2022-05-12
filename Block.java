package odev;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public long timeStamp;
   public int nonce;  
    public int id;
   public String transaction;

    public Block(int id, String transaction, String previousHash) {

        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
      this.hash=calculateHash();
    }
public String calculateHash()
    {
        
        String calculatedhash= Generatehash.sha256(Integer.toString(id) 
                    + previousHash 
                    + Long.toString(timeStamp) 
                    + Integer.toString(nonce) 
                    + transaction.toString());
   
       return calculatedhash;
    }
public String getHash() {  
  
    return this.hash;  
  
}  
public void incrementNonce() {  
  
    this.nonce++;  
}  
  
@Override  
  
public String toString() {  
  
    return this.id+"-"+this.transaction+"-"+this.hash+"-"+this.previousHash+"-";  
  
}  
}
