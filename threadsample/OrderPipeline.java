package threadsample;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import threadsample.InventoryService;
import threadsample.Order;
import threadsample.PaymentValidation;
import threadsample.ShippingService;

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

        for (int i = 0; i < orders.size(); i++) {
            Order iventory = paymentService.take().get();
            inventoryService.submit(new InventoryService(iventory));
        }

        for (int i = 0; i < orders.size(); i++) {
            Order reserved = inventoryService.take().get();
            inventoryService.submit(new ShippingService(reserved));
        }

        for (int i = 0; i < orders.size(); i++) {
            Order shipped = shippingService.take().get();
            System.out.println(" complete shipped : " + shipped);
        }

        shutdown();
    }

    private void shutdown() {
        paymentPool.shutdown();
        inventoryPool.shutdown();
        shippingPool.shutdown();
    }
}
