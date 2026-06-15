package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class HydratedWorkItemTest {

    @Test
    public void testSort() throws Exception {
        List<HydratedWorkItem> hydratedWorkItems = new ArrayList<>(List.of(
            createHydratedWorkItem(MONTH_DAY_YEAR_DATE_FORMAT.parse("10/30/2021")),
            createHydratedWorkItem(MONTH_DAY_YEAR_DATE_FORMAT.parse("06/16/2019")),
            createHydratedWorkItem(MONTH_DAY_YEAR_DATE_FORMAT.parse("03/07/2010")),
            createHydratedWorkItem(null),
            createHydratedWorkItem(MONTH_DAY_YEAR_DATE_FORMAT.parse("05/16/2020"))
        ));
        Collections.sort(hydratedWorkItems);
        Assertions.assertNull(hydratedWorkItems.get(0).getWorkAuthorizationSubmitDate());
        Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("03/07/2010"), hydratedWorkItems.get(1).getWorkAuthorizationSubmitDate());
        Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("06/16/2019"), hydratedWorkItems.get(2).getWorkAuthorizationSubmitDate());
        Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("05/16/2020"), hydratedWorkItems.get(3).getWorkAuthorizationSubmitDate());
        Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("10/30/2021"), hydratedWorkItems.get(4).getWorkAuthorizationSubmitDate());
        //Check if the list is in order, Assertions
    }

    private HydratedWorkItem createHydratedWorkItem(Date date) {
        HydratedWorkItem hydratedWorkItem = new HydratedWorkItem(new WorkItem());
        hydratedWorkItem.setWorkAuthorizationSubmitDate(date);
        return hydratedWorkItem;
    }
}
