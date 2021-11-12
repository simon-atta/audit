package com.avicss.audit.controller;

import com.avicss.audit.repository.SiteConfigurationRepository;
import com.avicss.audit.util.DataUtil;
import com.avicss.security.model.UserSecurity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
public class AbstractTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private SiteConfigurationRepository configurationRepository;

    @BeforeEach
    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        when(configurationRepository.getSiteConfigurationBySiteCode(anyString())).thenReturn(
                DataUtil.getSiteConfiguration()
        );

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("READ_AUDIT"));

        UserSecurity userSecurity = UserSecurity.SecurityUserBuilder()
                .username("simon")
                .siteCode("CAI")
                .authorities(authorities)
                .password("")
                .build();

        when(userDetailsService.loadUserByUsername(anyString())).thenReturn(
                userSecurity
        );

        Authentication authToken = new UsernamePasswordAuthenticationToken(
                userSecurity.getUsername(), userSecurity.getPassword(), userSecurity.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
}
