package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.dto.GetClientInfoRequest;
import com.huobi.reportingweb.dto.GetClientInfoResponse;
import com.huobi.reportingweb.exception.GenericApiException;
import com.huobi.reportingweb.service.ClientInformationService;
import com.huobi.reportingweb.service.TokenHandlerService;
import com.huobi.reportingweb.util.Constants;
import com.huobi.reportingweb.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerInfoResourceControlller {

    private final Logger log = LoggerFactory.getLogger(CustomerInfoResourceControlller.class);

    private ClientInformationService clientInformationService;

    private TokenHandlerService tokenHandlerService;

    public CustomerInfoResourceControlller(ClientInformationService clientInformationService, TokenHandlerService tokenHandlerService) {
        this.clientInformationService = clientInformationService;
        this.tokenHandlerService = tokenHandlerService;
    }

    /**
     * GET  /customer-infos/:id : get the "transactionId" GetClientInfoResponse.
     *
     * @param transactionId the id of the GetClientInfoResponse to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the customerInfo, or with status 404 (Not Found)
     */
    @GetMapping("/customer-infos/{transactionId}")
    public ResponseEntity<GetClientInfoResponse> getCustomerInfo(@PathVariable String transactionId) {
        log.debug("REST request to get GetClientInfoResponse : {}", transactionId);
        String serviceToken = tokenHandlerService.getServiceToken();
        Optional<GetClientInfoResponse> clientInfo = clientInformationService.getClientInfo(new GetClientInfoRequest(transactionId), serviceToken);
        clientInfo.ifPresent(resp -> {
            if(Constants.DECLINED.equals(resp.getStatus()))
                throw new GenericApiException(clientInfo.get().getMessage());
        });
        return ResponseUtil.wrapOrNotFound(clientInfo);
    }

}
