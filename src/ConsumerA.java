public abstract class ConsumerA implements consumer,Runnable{
    /*创建ConsumerA类，实现consumer和Runnable接口
    * runnable接口的是实现多线程的一种方式*/
    private String consumerName;
    private String telephoneNum;
    public ConsumerA(String consumerName, String telephoneNum) {
        this.consumerName = consumerName;
        this.telephoneNum = telephoneNum;
    }/*带有全部参数的构造方法*/

    public ConsumerA() {
    }/*空参构造*/

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }
    /*一系列的getXXX()和setXXX()方法。*/

    @Override
    public  abstract void run();/*抽象化run（）方法*/
}
