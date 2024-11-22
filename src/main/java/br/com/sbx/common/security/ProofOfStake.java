package br.com.sbx.common.security;

import java.util.Random;

/**
 *     
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProofOfStake implements ConsensusMechanism {
    @Override
    public String mineBlock(Block block, int difficulty) {
        Random random = new Random();
        if (random.nextInt(100) < 50) { 
            block.setHash(block.calculateHash());
            System.out.println("Bloco validado com PoS! Hash: " + block.getHash());
        } else {
            System.out.println("Validação de PoS falhou.");
        }
        
        return block.getHash();
    }

    @Override
    public boolean validateBlock(Block block) {
        return block.getHash().equals(block.calculateHash());
    }
}
