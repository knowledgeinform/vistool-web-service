package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class XSRFTest {
    private final String XSRF_TOKEN = "XSRF-TOKEN";

    @Autowired private MockMvc mockMvc;

    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;

    @Test
    @Disabled // NOTE: There is a known issue with the XSRF token not being set during testing inside a Docker container.
    public void testXSRFCookie() throws Exception {
        if(vistoolSecurityEnabled) {
            mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(status().isUnauthorized())
                .andExpect(cookie().exists(XSRF_TOKEN));
        }
    }
}
