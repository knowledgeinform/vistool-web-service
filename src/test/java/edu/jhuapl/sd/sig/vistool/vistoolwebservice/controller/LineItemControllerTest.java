package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
@WithMockUser(username = "mock_user", password = "mock_user", roles = "USER")
public class LineItemControllerTest {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private LineItemService lineItemService;

    private List<LineItem> lineItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        lineItemService.saveLineItems(lineItems);
    }

    @AfterEach
    public void afterEach() {
        lineItemService.deleteAllLineItems();
    }

    @Test
    public void testGetHydratedLineItems() throws Exception {
        List<HydratedLineItem> hydratedLineItems = lineItemService.getAllHydratedLineItems();
        mvc.perform(MockMvcRequestBuilders.get("/LineItems"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(hydratedLineItems)));
    }

    @Test
    public void testGetHydratedLineItem() throws Exception {
        HydratedLineItem hydratedLineItem = lineItemService.getHydratedLineItemById(lineItems.get(0).getId()).get();
        mvc.perform(MockMvcRequestBuilders.get("/LineItem/" + lineItems.get(0).getId()))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(hydratedLineItem)));

        mvc.perform(MockMvcRequestBuilders.get("/LineItem/" + Integer.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetHydratedLineItemVersions() throws Exception {
        Optional<HydratedLineItem> hydratedLineItems = lineItemService.getHydratedLineItemById(2L);
        List<HydratedLineItem> list = new ArrayList<>();
        list.add(hydratedLineItems.get());
        mvc.perform(MockMvcRequestBuilders.get("/LineItem/" + lineItems.get(1).getId() + "/versions"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(list)));

        mvc.perform(MockMvcRequestBuilders.get("/LineItem/" + Integer.MAX_VALUE + "/versions"))
                .andExpect(status().isNotFound());
    }
}
