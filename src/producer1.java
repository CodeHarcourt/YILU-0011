public class producer1 implements producer,Runnable{
    private Production b;/*创建产品的对象*/
    private String producerName;
    private String producerCard;

    public producer1(Production b, String producerName, String producerCard) {
        this.b = b;
        this.producerName = producerName;
        this.producerCard = producerCard;
    }


    public producer1(Production b) {
        this.b = b;
    }

    public Production getB() {
        return b;
    }

    public void setB(Production b) {
        this.b = b;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerCard() {
        return producerCard;
    }

    public void setProducerCard(String producerCard) {
        this.producerCard = producerCard;
    }
    /*一系列的getXXX()和setXXX()方法。*/

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
             b.put(i,producerName);
        }/*调用产品中生产的方法*/
    }
}
