package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.dto.LoginRequest;
import com.huobi.reportingweb.dto.LoginResponse;
import com.huobi.reportingweb.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService service;

    @Before
    public void setup() {
        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void login_ShouldIncludeTokenWhenCalled() throws Exception {
        Optional<LoginResponse> loginResponse=Optional.ofNullable(new LoginResponse("testtoken","APPROVED"));
        LoginRequest loginRequest = new LoginRequest("demo@bumin.com.tr","cjaiU8CV");
        when(service.login(loginRequest.getEmail(),loginRequest.getPassword())).thenReturn(loginResponse);
        mockMvc.perform(get("/login").param("email","demo@bumin.com.tr").param("password","cjaiU8CV"))
                .andExpect(status().isOk())
                .andExpect(view().name("/login"));
        verify(service).login(loginRequest.getEmail(),loginRequest.getPassword());
    }


}