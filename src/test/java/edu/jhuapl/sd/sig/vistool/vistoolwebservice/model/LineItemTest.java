package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities.LINE_ITEM_SERIALIZER;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities.createLineItem;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class LineItemTest {
    @Test
    public void testSerialization() {
        LineItem lineItem = createLineItem();
        String json = LINE_ITEM_SERIALIZER.toJson(lineItem);
        lineItem = LINE_ITEM_SERIALIZER.fromJson(json, LineItem.class);

        Assertions.assertEquals(1L, lineItem.getId());
        Assertions.assertEquals(1L, lineItem.getVersion());
        Assertions.assertEquals("WA-1", lineItem.getWorkAuthorizationNumber());
        Assertions.assertEquals("LI-1", lineItem.getLineItemNumber());
        Assertions.assertEquals(1, lineItem.getQuantity());
    }
}
