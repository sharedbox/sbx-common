package br.com.sbx.common.test.security;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.sbx.common.security.Block;
import br.com.sbx.common.security.Blockchain;
import br.com.sbx.common.security.ProofOfStake;
import br.com.sbx.common.security.ProofOfWork;

/**
 * 
 *  
 * @author Rafael Costi [rafaelcosti@outlook.com]
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlockchainTest {
    @Test
    public void testProofOfWorkMining() {
        ProofOfWork pow = new ProofOfWork();
        Blockchain blockchain = new Blockchain(pow);
        Block block = new Block(blockchain.getChain().get(0).getHash(), "Test1", "Test2", "Test3", "Test4", "Test5");
        blockchain.addBlock(block, 4);
        assertTrue(blockchain.isChainValid());
    }

    @Test
    public void testProofOfStakeValidation() {
        ProofOfStake pos = new ProofOfStake();
        Blockchain blockchain = new Blockchain(pos);
        Block block = new Block(blockchain.getChain().get(0).getHash(), "Test1", "Test2", "Test3", "Test4", "Test5");
        blockchain.addBlock(block, 4);
        assertTrue(blockchain.isChainValid());
    }
}
