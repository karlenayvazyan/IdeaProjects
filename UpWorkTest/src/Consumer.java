class Consumer extends Thread {
    private ProducerConsumerImpl pc;

    Consumer(ProducerConsumerImpl sharedObject) {
        super("CONSUMER");
        this.pc = sharedObject;
    }

    @Override
    public void run() {
        try {
            pc.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}