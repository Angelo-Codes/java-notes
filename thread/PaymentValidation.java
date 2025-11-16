import java.util.concurrent.Callable;

public class PaymentValidation implements Callable<Order> {

    private final Order order;

    public PaymentValidation(Order order) {
        this.order = order;
    }

    @Override
    public Order call() throws Exception {
        System.out.println(
            Thread.currentThread().getName() +
                " validating payment for " +
                order
        );
        Thread.sleep(800);
        System.out.println("paymnet ok for order : " + order);

        return order;
    }
}
