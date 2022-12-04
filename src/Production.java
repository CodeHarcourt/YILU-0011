import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Production {
    private String productionName;
    private int productionNUM;
    private boolean state=false;
    /*state变量是先将仓库产品表示为无，之后通过get1（）和put()方法对其值进行修改
    *表示产品被生产出来时为true，此时get1（）方法开始进行
    *产品被消费者获取后其值变为false，之后put（）方法开始进行*/
    Lock lock=new ReentrantLock();
    /*为了实现lock锁，要先创建一个lock锁的实例对象,在创建对象的时候体现了面向对象中的多态*/
    public Production(String productionName) {
        this.productionName = productionName;
    }

    public synchronized void put(int productionNUM,String producerName){
        lock.lock();
        /*对生产资料进行上锁*/
            try{
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                /*这一步是让此线程休眠，从而实现生产需要一定时间的效果*/
                if(!state){
                    this.productionNUM=productionNUM;
                    System.out.print(producerName);
                    producer.produce();
                    System.out.print(producerName);
                    producer.complain();
                    System.out.println(producerName+"生产完成第"+this.productionNUM+"个"+this.productionName);
                    System.out.print(producerName);
                    producer.AttractConsumer();
                    state=true;
                    /*修改状态为true表示此时有产品可以进行获取*/
                    notifyAll();
                    /*唤醒消费者的所有线程，消费者开始抢夺cpu时间片，来抢夺产品*/
                    this.wait();
                    /*让此线程开始等待，直到消费者获取产品后，出现notifyall（），之后此线程被唤醒*/
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
                /*释放锁*/
            }

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }/*让此线程休眠一段时间*/
    }
    public synchronized void get1(String consumerName){
        if(!state) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /*这一步是如果state为false代表此时没有产品，消费者无法获取，此线程进入等待状态*/
        }
        if((this.productionNUM%2)==1) {
            if(state){
            System.out.print(consumerName);
            consumer.consume();
            System.out.println(consumerName + "拿到第" + this.productionNUM + "个" + this.productionName);
            System.out.print(consumerName);
            consumer.Like();
            System.out.print(consumerName);
            consumer.Share();
            state=false;
            /*消费者获取生产资料后，state变为false表示产品已抢完*/
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                /*抢购完成，让此线程进入休眠一段时间*/
            this.notifyAll();}
            /*产品被获取，唤醒生产者的线程，重新进行产品生产*/
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /*线程进入等待状态，直到下次被唤醒*/
        }else{
            if(state){
            System.out.print(consumerName);
            consumer.consume();
            System.out.println(consumerName + "拿到第" + this.productionNUM + "个" + this.productionName);
            System.out.print(consumerName);
            consumer.Complain();
            System.out.print(consumerName);
            consumer.ReturnGoods();
            state=false;
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            this.notifyAll();}
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*if...else的使用是为了体现对产品持有两种不同态度的消费者*/

}}
