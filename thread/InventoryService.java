import java.util.concurrent.Callable;

public class InventoryService implements Callable<Order> {

    public final Order order;

    public Inventoryservice(Order order) {
        this.order = order;
    }

    public Order call() throws Exception {
        System.out.println("checking inventory for : " + order);
        Thread.sleep(600)

        System.out.println("inventory reserve ok for : " + order);
        return order;
    }
}
