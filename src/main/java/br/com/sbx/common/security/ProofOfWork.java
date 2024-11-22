package br.com.sbx.common.security;

/**
 *     
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProofOfWork implements ConsensusMechanism {
	/**
	 * 
	 */
    @Override
    public String mineBlock(Block block, int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!block.getHash().substring(0, difficulty).equals(target)) {
            block.incrementNonce();
            block.setHash(block.calculateHash());
        }
        System.out.println("Bloco minerado com PoW! Hash: " + block.getHash());
        
        return block.getHash();
    }

    @Override
    public boolean validateBlock(Block block) {
        return block.getHash().equals(block.calculateHash());
    }
}
