package br.com.sbx.common.security;

import java.util.ArrayList;
import java.util.List;

/**
 *     
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class Blockchain {
	/**
	 * 
	 */
    private List<Block> chain;
    
    /**
     * 
     */
    private ConsensusMechanism consensusMechanism;
    
    /**
     * 
     * @param consensusMechanism
     */
    public Blockchain(ConsensusMechanism consensusMechanism) {
        this.consensusMechanism = consensusMechanism;
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

	/**
     * 
     * @param values
     * @return
     */
    private Block createGenesisBlock(String... values) {
        return new Block("0", values);
    }
    
    /**
     * 
     * @param block
     * @param difficulty
     */
    public void addBlock(Block block, int difficulty, String... values) {
        Block previousBlock = chain.get(chain.size() - 1);
        block = new Block(previousBlock.getHash(), values);
        consensusMechanism.mineBlock(block, difficulty);
        chain.add(block);
    }
    
    /**
     * 
     * @return
     */
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!consensusMechanism.validateBlock(currentBlock)) {
                System.out.println("Hash inválido no bloco " + i);
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Hash anterior inválido no bloco " + i);
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * @return
     */
    public List<Block> getChain(){
    	return this.chain;
    }
}
