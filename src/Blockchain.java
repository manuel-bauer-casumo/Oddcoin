import java.util.ArrayList;

public class Blockchain {
    
    private ArrayList<Block> blocks;     
    private ArrayList<Transaction> pendingTransactions;

    public final int difficulty = 4;
    public final float reward = 50;

    public Blockchain() {
        this.pendingTransactions = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.blocks.add(Block.getGenesisBlock());
    }

    public void addBlock(Block block, Miner miner) {
        if (proofOfWork(block)) {
            this.blocks.add(block);
            this.pendingTransactions.add(new Transaction("Casumo", miner.getMinerAddress(), reward));
            this.pendingTransactions.removeAll(block.getAllTransactions());
        }
    }

    public void addTransaction(Transaction transaction) {
        this.pendingTransactions.add(transaction);
    }

    public Block getLast() {
        return this.blocks.get(this.blocks.size()-1);
    }

    public ArrayList<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public boolean proofOfWork(Block block) {
        String actual = block.getHash().substring(0, difficulty);
        String challenge = ("0").repeat(difficulty);
        return actual.equals(challenge);
    }

}