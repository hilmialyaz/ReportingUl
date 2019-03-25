package com.huobi.reportingweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionReportResponse {
    private String status;

    private List<TransactionReport> response;
}
