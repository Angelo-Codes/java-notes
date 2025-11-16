public class ShippingService implements Callable<Order> {

    public final Order order;

    public ShippingService(Order order) {
        this.order = order;
    }

    @Override
    public Order call() throws Exception {
        System.out.println("checking shipping service for : " + order);
        Thread.sleep(700);

        System.out.println("generate label shipping for : " + order);
        return order;
    }
}
