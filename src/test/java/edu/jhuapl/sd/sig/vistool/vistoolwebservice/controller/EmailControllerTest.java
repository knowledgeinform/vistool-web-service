package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.EmailUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(EmailUtilities.class)
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class EmailControllerTest {
    @Autowired MockMvc mvc;

    @Test
    @WithMockUser
    public void testEmailController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/email/support")
            .with(csrf())
            .content(this.getClass().getSimpleName()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
