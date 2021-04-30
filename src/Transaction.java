public class Transaction {

    private String sender; 
    private String receiver; 
    private Float amount;
    private Long time; 

       
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Float getAmount() {
        return amount;
    }

    public Transaction(String sender, String receiver, Float amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.time = System.currentTimeMillis();
    }

    public String getHash() {
        
        StringBuilder b = new StringBuilder();
        b.append(sender)
            .append(receiver)
            .append(amount.toString())
            .append(time.toString());

        return Sha256.hash256(b.toString());

    }
    
}
