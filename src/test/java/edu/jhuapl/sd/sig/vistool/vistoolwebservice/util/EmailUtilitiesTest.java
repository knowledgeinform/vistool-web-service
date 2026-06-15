package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class EmailUtilitiesTest {
    @Autowired EmailUtilities emailUtilities;

    @Test
    public void testSendEmail() {
        EmailUtilities emailUtilities = Mockito.mock(EmailUtilities.class);
        emailUtilities.sendEmail(this.getClass().getSimpleName());
    }
}
