package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.dto.TransactionReportRequest;
import com.huobi.reportingweb.dto.TransactionReportResponse;
import com.huobi.reportingweb.dto.TransactionRequest;
import com.huobi.reportingweb.dto.TransactionResponse;
import com.huobi.reportingweb.exception.GenericApiException;
import com.huobi.reportingweb.service.TokenHandlerService;
import com.huobi.reportingweb.service.TransactionService;
import com.huobi.reportingweb.util.Constants;
import com.huobi.reportingweb.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionResourceController {

    private final Logger log = LoggerFactory.getLogger(TransactionResourceController.class);

    private static final String ENTITY_NAME = "transactionReport";

    private TransactionService service;

    private TokenHandlerService tokenHandlerService;

    public TransactionResourceController(TransactionService service, TokenHandlerService tokenHandlerService) {
        this.service = service;
        this.tokenHandlerService = tokenHandlerService;
    }


    /**
     * GET  /transaction-reports/ start= : get the "id" transactionReport.
     *
     * @param start the Start date of the transactionReport to retrieve
     * @param end the End date of the transactionReport to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the transactionReport, or with status 404 (Not Found)
     */
    @GetMapping("/transaction-reports")
    public ResponseEntity<TransactionReportResponse> getTransactionReport(@RequestParam("start") String start,@RequestParam("end")  String end) {
        log.debug("REST request to get TransactionReport : {}", start,end);
        Optional<TransactionReportResponse> response = service.reportTransaction(new TransactionReportRequest(start,end),tokenHandlerService.getServiceToken());
        response.ifPresent(resp -> {
            if(Constants.DECLINED.equals(resp.getStatus()))
                throw new GenericApiException(response.get().getMessage());
        });
        return ResponseUtil.wrapOrNotFound(response );
    }


    /**
     * GET  /transactions/:transactionId : get the "transactionId" transaction.
     *
     * @param transactionId the id of the transaction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the transaction, or with status 404 (Not Found)
     */
    @GetMapping("/transactions/{transactionId}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable String transactionId) {
        log.debug("REST request to get Transaction : {}", transactionId);
        Optional<TransactionResponse> response = service.getTransaction(new TransactionRequest(transactionId),tokenHandlerService.getServiceToken());
        response.ifPresent(resp -> {
            if(Constants.DECLINED.equals(resp.getStatus()))
                throw new GenericApiException(response.get().getMessage());
        });
        return ResponseUtil.wrapOrNotFound(response );
    }
}
