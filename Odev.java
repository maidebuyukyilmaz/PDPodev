package odev;
import com.google.gson.GsonBuilder;


public class Odev {

  
    public static void main(String[] args) {
      
        Blockchain blockchain = new Blockchain();  
        Miner miner = new Miner();  
        
        Block block0 = new Block(0,"transaction1",Constants.beginninghash); 
        miner.mine(block0, blockchain);  
        
        Block block1 = new Block(1,"transaction2",blockchain.getBlockChain().get(blockchain.size()-1).hash); 
        miner.mine(block1, blockchain);  
        
        Block block2 = new Block (2,"transaction3",blockchain.getBlockChain().get(blockchain.size()-1).hash); 
        miner.mine(block2, blockchain);  
        
        System.out.println("\n"+ "BLOCKCHAIN:\n"+blockchain); 
        System.out.println("Miner's reward: " + miner.getReward());  
        System.out.println("blockchain is valid: " + blockchain.isChainValid());
         System.out.println("The blockchain");
      
         String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
    }

}
