package mustow.etienne;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CiccioAcceptanceTest {

    @Mock OrderRepository orderRepository;
    @Mock OrderFactory orderFactory;

    @Test
    public void can_create_order() {
        Order order = new Order();
        orderFactory = new OrderFactory();
        OrderParams orderParams = new OrderParams();

        given(orderFactory.create(orderParams)).willReturn(order);

        OrderService orderService = new OrderService(orderRepository, orderFactory);


        orderService.createOrder(orderParams);

        verify(orderRepository).saveOrder(order);
    }
}
