package xyz.yiming.web.domain.fulfillorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 核心的领域模型：履约订单
 * 聚合根
 */
public class FulfillOrder {

    private Long orderId;

    private List<FulfillOrderItem> fulfillOrderItems;

    private DeliveryAddress deliveryAddress;

    private PayType payType;

    private PaymentDetail paymentDetail;

    private FulfillOrderStatus fulfillOrderStatus;

    private LogisticsOrder logisticsOrder;

    public List<String> getSkuCodes() {
        return new ArrayList<>();
    }

    public List<Long> getPurchaseCounts() {
        return new ArrayList<>();
    }

    public void allocateToWarehouse() {
    }

    public void allocateToLogisticsCompany() {
    }

    public Long getOrderId() {
        return orderId;
    }

}
