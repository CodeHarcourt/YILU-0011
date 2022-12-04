public interface consumer{
    public static void consume(){
        System.out.println("花钱购买生产者所生产的资料");
    }
    public static void Like(){
        System.out.println("拍了拍生产者并说了句：“资料真不错，下次还来”");
    }
    public static void Share(){
        System.out.println("将所获取资料与小组成员进行分享");
    }
    public static void ReturnGoods(){
        System.out.println("骂骂咧咧道：”什么垃圾玩意，退货“");
    }
    public static void Complain(){
        System.out.println("对商品进行投诉");
    }
}/*创建消费者的接口，并在其中加入消费者经常会有的一系列行为*/
