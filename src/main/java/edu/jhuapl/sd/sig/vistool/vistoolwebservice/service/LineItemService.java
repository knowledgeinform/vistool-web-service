package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.LineItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.LineItemRepository;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.LineItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;


@Log4j2
@Service
public class LineItemService {
    @Autowired LineItemRepository lineItemRepository;
    @Autowired LineItemHydrationLogic lineItemHydrationLogic;

    private final Object LOCK = new Object();

    public List<LineItem> getAllLineItems() {
        return lineItemRepository.findAll();
    }

    public Optional<LineItem> getLineItemById(Long id) {
        return lineItemRepository.findOne(idEqualTo(id));
    }

    public Optional<LineItem> getLineItemByWorkAuthorizationNumberAndLineItemNumber(
            String workAuthorizationNumber, String lineItemNumber)
    {
        try {
            return lineItemRepository.findOne(
                where(
                    workAuthorizationNumberEqualTo(workAuthorizationNumber)
                    .and(lineItemNumberEqualTo(lineItemNumber))
                )
            );
        } catch (Exception e) {
            log.error("Could not retrieve line item", e);
            return Optional.empty();
        }
        
    }

    public List<HydratedLineItem> getAllHydratedLineItems() {
        List<LineItem> lineItems = (List<LineItem>) getAllLineItems();
        return lineItemHydrationLogic.hydrateLineItems(new ArrayList<>(lineItems));
    }

    public Optional<HydratedLineItem> getHydratedLineItemById(Long id) {
        Optional<LineItem> optionalLineItem = getLineItemById(id);
        if(optionalLineItem.isPresent()) {
            HydratedLineItem hydratedLineItem = lineItemHydrationLogic.hydrateLineItem(optionalLineItem.get());
            return Optional.of(hydratedLineItem);
        }
        return Optional.empty();
    }

    public LineItem saveLineItem(LineItem lineItem) {
        synchronized(LOCK) {
            if(lineItem.getId() == null) {
                Optional<Long> optionalMaxId = getMaxId();
                if(optionalMaxId.isPresent()) {
                    lineItem.setId(optionalMaxId.get() + 1);
                } else {
                    lineItem.setId(1L);
                }
            }
            Long lineItemVersion = lineItem.getVersion();
            if(lineItemVersion == null) {
                lineItemVersion = 0L;
            }

            lineItem.setVersion(++lineItemVersion);

            return lineItemRepository.save(lineItem);      
        }
    }

    public List<LineItem> saveLineItems(List<LineItem> lineItems) {
        List<LineItem> savedLineItems = new ArrayList<>();
        for (LineItem lineItem : lineItems) {
            savedLineItems.add(saveLineItem(lineItem));
        }
        return savedLineItems;
    }

    public void deleteLineItem(LineItem lineItem) {
        synchronized(LOCK) {
            lineItemRepository.delete(lineItem);
        }
    }

    public void deleteAllLineItems() {
        synchronized(LOCK) {
            lineItemRepository.deleteAll();
        }
    }

    private Optional<Long> getMaxId() {
        List<LineItem> lineItems = lineItemRepository.findAll(where(idMaximum()));
        if(!lineItems.isEmpty()) {
            return Optional.of(lineItems.get(0).getId());
        }
        return Optional.empty();
    }
}
