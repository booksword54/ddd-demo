package xyz.yiming.web.domain.fulfillorder;

import java.util.List;

/**
 * 核心的领域模型：履约订单
 * 聚合根
 */
public class FulfillOrder {

    private OrderId orderId;

    private List<FulfillOrderItem> fulfillOrderItems;

    private DeliveryAddress deliveryAddress;

    private PayType payType;

    private PaymentDetail paymentDetail;

    private FulfillOrderStatus fulfillOrderStatus;

    private LogisticsOrder logisticsOrder;

    public void allocateToWarehouse() {
    }

    public void allocateToLogisticsCompany() {
    }

}
