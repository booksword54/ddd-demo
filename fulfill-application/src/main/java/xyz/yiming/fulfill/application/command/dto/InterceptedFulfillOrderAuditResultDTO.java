package xyz.yiming.fulfill.application.command.dto;

public class InterceptedFulfillOrderAuditResultDTO {

    private Long orderId;

    private Boolean auditResult;

    public Long getOrderId() {
        return orderId;
    }

    public InterceptedFulfillOrderAuditResultDTO setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Boolean getAuditResult() {
        return auditResult;
    }

    public InterceptedFulfillOrderAuditResultDTO setAuditResult(Boolean auditResult) {
        this.auditResult = auditResult;
        return this;
    }
}
