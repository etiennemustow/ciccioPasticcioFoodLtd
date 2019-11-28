package mustow.etienne;

import java.time.LocalDate;
import java.util.List;

public class OrderParams {

    int employeeId;
    int customerId;

    LocalDate requiredDate;
    ShippingAddress shippingAddress;
    List<OrderProduct> products;
    int discountPercentage;
}
