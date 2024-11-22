package br.com.sbx.common.security;

/**
 *     
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConsensusMechanism {
	/**
	 * 
	 * @param block
	 * @param difficulty
	 */
	String mineBlock(Block block, int difficulty);
    
    /**
     * 
     * @param block
     * @return
     */
    boolean validateBlock(Block block);
}
