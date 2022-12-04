public class testMode {
    public static void main(String[] args) {
        Production b=new Production("万通筋骨贴");
        /*创建生产资料对象，为共享数据区域*/
        producer1 pd = new producer1(b,"赵老钱","00001");
        /*创建生产者对象*/
        Consumer1 cs1=new Consumer1("王五","789789789",b);
        Consumer1 cs2=new Consumer1("李四","123123123",b);
        Consumer1 cs3=new Consumer1("老八","99999",b);
        /*创建消费者对象*/
        Thread t1=new Thread(pd);
        /*创建生产者线程*/
        Thread t2=new Thread(cs1);
        Thread t3=new Thread(cs2);
        Thread t4=new Thread(cs3);
        /*创建消费者线程*/
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /*所有线程开始运行*/
    }
}
