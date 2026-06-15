package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.apache.logging.log4j.core.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class VistoolXSSFilterTest {
    private final String CLEAN_TEXT = "LOREMIPSUM";
    private final String TAINTED_TEXT = "LOREM<script>alert(1);</script>IPSUM";
    private final String X_XSS_PROTECTION_HEADER = "X-XSS-Protection";

    @Autowired private MockMvc mockMvc;

    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;

    @Test
    public void doFilter() throws ServletException, IOException {
        VisToolXSSFilter visToolXSSFilter = new VisToolXSSFilter();

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        MockFilterChain mockFilterChain = new MockFilterChain();

        mockHttpServletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        mockHttpServletRequest.setContent(TAINTED_TEXT.getBytes(StandardCharsets.UTF_8)); // Sets the Request Body
        mockHttpServletRequest.addParameter("NAME", TAINTED_TEXT); // Sets a Request Parameter
        mockHttpServletRequest.addHeader("NAME", TAINTED_TEXT);
        mockHttpServletRequest.setQueryString(TAINTED_TEXT);

        visToolXSSFilter.doFilter(mockHttpServletRequest, mockHttpServletResponse, mockFilterChain);
        VisToolXSSRequestWrapper servletRequest = (VisToolXSSRequestWrapper) mockFilterChain.getRequest();

        Assertions.assertEquals(CLEAN_TEXT, IOUtils.toString(servletRequest.getReader()));
        Assertions.assertEquals(CLEAN_TEXT, servletRequest.getParameter("NAME"));
        Assertions.assertEquals(CLEAN_TEXT, servletRequest.getHeader("NAME"));
        Assertions.assertEquals(CLEAN_TEXT, servletRequest.getQueryString());
    }

    @Test
    public void testUnauthorizedLogin() {
        try {
            if(vistoolSecurityEnabled) {
                mockMvc.perform(MockMvcRequestBuilders.post("/login"))
                    .andExpect(status().isUnauthorized())
                    .andExpect(header().exists(X_XSS_PROTECTION_HEADER));
            }
            else {
                mockMvc.perform(MockMvcRequestBuilders.post("/login"))
                    .andExpect(status().isNotFound())
                    .andExpect(header().doesNotExist(X_XSS_PROTECTION_HEADER));
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void testUnauthorizedLogout() {
        try {
            if(vistoolSecurityEnabled) {
                mockMvc.perform(MockMvcRequestBuilders.post("/logout"))
                        .andExpect(status().isForbidden())
                        .andExpect(header().exists(X_XSS_PROTECTION_HEADER));
            }
            else {
                mockMvc.perform(MockMvcRequestBuilders.post("/logout"))
                        .andExpect(status().isNotFound())
                        .andExpect(header().doesNotExist(X_XSS_PROTECTION_HEADER));
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
