package xyz.yiming.web.domain.fulfillorder;

import xyz.yiming.web.domain.gateway.FulfillOrderGateway;
import xyz.yiming.web.domain.warehouse.Warehouse;

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

    // 需要持有 FulfillOrderGateway 需要靠其他人注入进来
    private FulfillOrderGateway fulfillOrderGateway;

    public void allocateToWarehouse(Warehouse warehouse) {
        // 真正进行分配时，保存履约订单和仓储的分配关系
        fulfillOrderGateway.saveAllocatedWarehouse(this, warehouse);
    }

    public void allocateToLogisticsCompany() {
    }

    public List<String> getSkuCodes() {
        return new ArrayList<>();
    }

    public List<Long> getPurchaseCounts() {
        return new ArrayList<>();
    }

    public Long getOrderId() {
        return orderId;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<FulfillOrderItem> getFulfillOrderItems() {
        return fulfillOrderItems;
    }

    public void setFulfillOrderGateway(FulfillOrderGateway fulfillOrderGateway) {
        this.fulfillOrderGateway = fulfillOrderGateway;
    }

}
