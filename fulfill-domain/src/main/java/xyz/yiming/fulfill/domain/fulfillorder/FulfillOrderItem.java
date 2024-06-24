package xyz.yiming.fulfill.domain.fulfillorder;

public class FulfillOrderItem {

    private String skuCode;

    private Long purchaseCount;

    public String getSkuCode() {
        return skuCode;
    }

    public FulfillOrderItem setSkuCode(String skuCode) {
        this.skuCode = skuCode;
        return this;
    }

    public Long getPurchaseCount() {
        return purchaseCount;
    }

    public FulfillOrderItem setPurchaseCount(Long purchaseCount) {
        this.purchaseCount = purchaseCount;
        return this;
    }

}
