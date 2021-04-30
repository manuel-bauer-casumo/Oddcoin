public class Miner {
    private Blockchain blockchain;
    private String minerAddress;

    public String getMinerAddress(){
        return minerAddress;
    }

    public Miner(Blockchain blockchain, String minerAddress) {
        this.blockchain = blockchain;
        this.minerAddress = minerAddress;
    }

    public void mine() {
        Block lastBlock = this.blockchain.getLast();
        Block candidateBlock = new Block(lastBlock.getHash(), lastBlock.getIndex() +1);

        blockchain.getPendingTransactions().forEach((t) -> { 
            candidateBlock.addTransaction(t);
        });

        Long nonce = System.currentTimeMillis();

        while (blockchain.proofOfWork(candidateBlock) == false) {
            candidateBlock.setNonce(nonce);
            nonce++;
        }

        this.blockchain.addBlock(candidateBlock, this);

    }


}
