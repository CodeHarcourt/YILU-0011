import static java.lang.Thread.sleep;

public class Consumer1 extends ConsumerA {
    /*Consumer1子类继承ConsumerA父类，继承所有成员变量*
    *由于ConsumerA是一个抽象类，所以要重写其中的run方法*/
     Production b;
    /*创建产品类的对象，由于生产资料是共享数据，所以并未对其进行私有化*/


    public Consumer1(String consumerName, String telephoneNum, Production b) {
        super(consumerName, telephoneNum);
        this.b = b;
    }/*带有子类和父类中全部参数的构造方法*/

    public Consumer1(Production b) {
        this.b = b;
    }/*只带有子类参数的构造方法*/

    @Override
    public void run() {
        while (true) {
            b.get1(super.getConsumerName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }/*这一步是让此线程休眠，放弃占有CPU的时间片，让给其他线程使用
            *为了实现让另外的消费者进行抢购的效果*/
        }/*循环调用获取生产资料的操作*/
    }
}
