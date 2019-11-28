package mustow.etienne;

public class OrderService {
    private OrderRepository orderRepository;
    private OrderFactory orderFactory;

    public OrderService(OrderRepository orderRepository, OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
    }

    public void createOrder(OrderParams orderParams) {
        throw new UnsupportedOperationException();
    }
}
