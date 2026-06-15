package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.ArchivedLineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class LineItemController {
    @Autowired private LineItemService lineItemService;
    @Autowired private ArchivedLineItemService archivedLineItemService;

    @GetMapping(value = "/LineItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HydratedLineItem>> getHydratedLineItems() {
        return ResponseEntity.ok(lineItemService.getAllHydratedLineItems());
    }

    @GetMapping(value = "/LineItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HydratedLineItem> getHydratedLineItem(@PathVariable("id") Long id) {
        Optional<HydratedLineItem> optionalHydratedLineItem = lineItemService.getHydratedLineItemById(id);
        if(optionalHydratedLineItem.isPresent()) {
            return ResponseEntity.ok(optionalHydratedLineItem.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/LineItem/{id}/versions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HydratedLineItem>> getHydratedLineItemVersions(@PathVariable("id") Long id) {
        try {List<HydratedLineItem> hydratedLineItems = archivedLineItemService.getAllHydratedLineItemVersionsById(id);
            hydratedLineItems.add(lineItemService.getHydratedLineItemById(id).get());
    
            if (hydratedLineItems != null && !hydratedLineItems.isEmpty()) {
                return ResponseEntity.ok(hydratedLineItems);
            }
        } catch (Exception e) {
            log.error("Did not find any current line items with id " + id, e);
        }
        return ResponseEntity.notFound().build();  
    }
}
