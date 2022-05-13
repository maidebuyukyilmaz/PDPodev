package odev;

import java.util.ArrayList;
import java.util.List;
public class Blockchain {

    private List<Block> blockchain;

    public Blockchain() {
        this.blockchain = new ArrayList<>();

    }

    public void addBlock(Block block) {
        this.blockchain.add(block);
    }

    public List<Block> getBlockChain() {
        return this.blockchain;
    }

    public int size() {
        return this.blockchain.size();
    }

    public Boolean isChainValid() {

        Block currentBlock;
        Block previousBlock;
      

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.getHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            
         
        }
    return true;
    }

    @Override
    public String toString() {
        String blockchain = "";
        for (Block block : this.blockchain) {
            blockchain += block.toString() + "\n";
        }
        return blockchain;
    }

}
