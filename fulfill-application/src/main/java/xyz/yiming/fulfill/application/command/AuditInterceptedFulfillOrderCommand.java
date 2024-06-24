package xyz.yiming.fulfill.application.command;

import xyz.yiming.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;

public class AuditInterceptedFulfillOrderCommand {

    private InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO;

    public InterceptedFulfillOrderAuditResultDTO getInterceptedFulfillOrderAuditResultDTO() {
        return interceptedFulfillOrderAuditResultDTO;
    }

    public AuditInterceptedFulfillOrderCommand setInterceptedFulfillOrderAuditResultDTO(InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO) {
        this.interceptedFulfillOrderAuditResultDTO = interceptedFulfillOrderAuditResultDTO;
        return this;
    }
}
