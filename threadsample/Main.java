import java.util.Arrays;
import java.util.List;
import threadsample.Order;
import threadsample.OrderPipeline;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(1),
            new Order(2),
            new Order(3),
            new Order(4),
            new Order(5)
        );

        new OrderPipeline().processOrders(orders);
    }
}
