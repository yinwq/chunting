import com.yinwq.chunting.entity.Goods;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/3/13 14:56
 */
public class Test {
    public static void main(String[] args) {
        int i1 = 3;
        int i2 = i1;
        i2 = 4;
        System.err.println("i1==" + i1);
        System.err.println("i2==" + i2);

        Goods goods1 = new Goods();
        goods1.setGoodsStock(5);
        Goods goods2 = goods1;
        goods2.setGoodsStock(6);
        System.err.println("goods1.goodsStock==" + goods1.getGoodsStock());
        System.err.println("goods2.goodsStock==" + goods2.getGoodsStock());

    }
}
