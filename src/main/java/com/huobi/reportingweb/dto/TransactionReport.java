package com.huobi.reportingweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionReport {
    private Integer count;

    private Long total;

    private String currency;
}
