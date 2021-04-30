public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Blockchain");
        Blockchain odd = new Blockchain();

        Miner miner = new Miner(odd, "Domenico");

        
        for (int i = 0; i< 10; i++) {
                odd.addTransaction(new Transaction("Casumo", "Manuel", (float) 200));
        }

        miner.mine();

        System.out.println(odd.getLast().getHash());

        miner.mine();
        
        System.out.println(odd.getLast().getHash());
    }
}

