import java.util.ArrayList;

public class Block {

    private String prev;
    private String hash; 
    private int index;
    private Long time;
    private Long nonce;

    private ArrayList<Transaction> transactions;

    public String getPrev() {
        return prev;
    }
  
    public String getHash() {
        return hash;
    }
    public int getIndex() {
        return index;
    }
    public Long getTime() {
        return time;
    }
    public Long getNonce() {
        return nonce;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return this.transactions;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
        computeHash();
    }

    public static Block getGenesisBlock() {
     
        final String genesisMessage = "Casumo is Awesome";
        final Block genesisBlock = new Block(Sha256.hash256(genesisMessage), 0);
        genesisBlock.addTransaction(new Transaction("Universe", "Casumo", (float)1000000000));
        return genesisBlock;

    }

    public Block(String previousHash, int index) {
        this.transactions = new ArrayList<>();
        this.time = System.currentTimeMillis();
        this.prev = previousHash;
        this.index = index;
        this.nonce = (long)0;
        
        this.computeHash();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.computeHash();
    }

    private void computeHash() {
        final StringBuilder b = new StringBuilder();
        b.append(this.nonce.toString())
            .append(this.prev)
            .append(this.index)
            .append(this.time.toString());
        transactions.forEach(t -> b.append(t.getHash()));
        this.hash = Sha256.hash256(b.toString());
    }


}