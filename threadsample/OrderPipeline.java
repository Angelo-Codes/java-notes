package threadsample;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import threadsample.PaymentValidation;

public class OrderPipeline {

    private final ExecutorService paymentPool = Executors.newFixedThreadPool(3);
    private final ExecutorService inventoryPool = Executors.newFixedThreadPool(
        3
    );
    private final ExecutorService shippingPool = Executors.newFixedThreadPool(
        3
    );

    private final CompletionService<Order> paymentService =
        new ExecutorCompletionService<>(paymentPool);
    private final CompletionService<Order> inventoryService =
        new ExecutorCompletionService<>(inventoryPool);
    private final CompletionService<Order> shippingService =
        new ExecutorCompletionService<>(shippingPool);

    public void processOrders(List<Order> orders) throws Exception {
        for (Order order : orders) {
            paymentService.submit(new PaymentValidation(order));
        }
    }
}
