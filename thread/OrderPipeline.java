import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class OrderPipeline {
    private final ExecutorService paymentPool = Executors.newFixedThreadPool(3);
    private final ExecutorService inventoryPool = Executors.newFixedThreadPool(3);
    private final ExecutorService shippingPool = Executors.newFixedThreadPool(3);

    private final CompletionService<Order>

}
