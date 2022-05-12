
package odev;


public class Miner {
    
    private double reward;    
    public void mine(Block block, Blockchain blockchain) {  
  
        while(mineblock(block)) {  
          
            block.calculateHash();  
            block.incrementNonce();  
        }  
        System.out.println(block+" has just mined...");  
        System.out.println("Hash is: "+block.getHash());          
       
        blockchain.addBlock(block);  
       
        reward+=Constants.minerreward;  
    }
   
    public boolean mineblock(Block block) {  
  
        String target = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');  
  
        return !block.calculateHash().substring (0, Constants.DIFFICULTY).equals (target);  
    }  
    public double getReward() {  
        return this.reward;  
    }  
}
