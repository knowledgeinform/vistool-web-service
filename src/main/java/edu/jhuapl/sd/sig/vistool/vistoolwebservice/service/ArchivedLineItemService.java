package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.LineItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.AbstractLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ArchivedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ArchivedLineItemRepository;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ArchivedLineItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;


@Service
public class ArchivedLineItemService {
    @Autowired ArchivedLineItemRepository archivedLineItemRepository;
    @Autowired LineItemHydrationLogic lineItemHydrationLogic;

    private final Object LOCK = new Object();

    public List<ArchivedLineItem> getAllLineItemsWithMaxVersion() {
        return archivedLineItemRepository.findAll(
            where(versionMaximum())
        );
    }

    public Optional<ArchivedLineItem> getLineItemWithMaxVersionById(Long id) {
        return archivedLineItemRepository.findOne(
            where(
                versionMaximum()
                .and(idEqualTo(id))
            )
        );
    }

    public List<ArchivedLineItem> getAllLineItemVersionsById(Long id) {
        return archivedLineItemRepository.findAll(
            where(
                idEqualTo(id)
            )
        );
    }

    public List<ArchivedLineItem> getAllLineItemVersionsByWorkAuthorizationNumberAndLineItemNumber(
            String workAuthorizationNumber, String lineItemNumber)
    {
        return archivedLineItemRepository.findAll(
            where(
                workAuthorizationNumberEqualTo(workAuthorizationNumber)
                .and(lineItemNumberEqualTo(lineItemNumber))
            )
        );
    }

    public Optional<ArchivedLineItem> getLineItemWithMaxVersionByWorkAuthorizationNumberAndLineItemNumber(
            String workAuthorizationNumber, String lineItemNumber)
    {
        return archivedLineItemRepository.findOne(
            where(
                workAuthorizationNumberEqualTo(workAuthorizationNumber)
                .and(lineItemNumberEqualTo(lineItemNumber))
                .and(versionMaximum())
            )
        );
    }

    public List<HydratedLineItem> getAllHydratedLineItemsWithMaxVersion() {
        List<ArchivedLineItem> lineItems = getAllLineItemsWithMaxVersion();
        return lineItemHydrationLogic.hydrateLineItems(new ArrayList<AbstractLineItem>(lineItems));
    }

    public Optional<HydratedLineItem> getHydratedLineItemWithMaxVersionById(Long id) {
        Optional<ArchivedLineItem> optionalLineItem = getLineItemWithMaxVersionById(id);
        if(optionalLineItem.isPresent()) {
            HydratedLineItem hydratedLineItem = lineItemHydrationLogic.hydrateLineItem(optionalLineItem.get());
            return Optional.of(hydratedLineItem);
        }
        return Optional.empty();
    }

    public List<HydratedLineItem> getAllHydratedLineItemVersionsById(Long id) {
        List<ArchivedLineItem> lineItems = getAllLineItemVersionsById(id);
        return lineItemHydrationLogic.hydrateLineItems(new ArrayList<>(lineItems));
    }

    public ArchivedLineItem saveLineItem(ArchivedLineItem lineItem) {
        synchronized(LOCK) {
            return archivedLineItemRepository.save(lineItem);
        }
    }

    public List<ArchivedLineItem> saveLineItems(List<ArchivedLineItem> lineItems) {
        List<ArchivedLineItem> savedLineItems = new ArrayList<>();
        for (ArchivedLineItem lineItem : lineItems) {
            savedLineItems.add(saveLineItem(lineItem));
        }
        return savedLineItems;
    }

    public void deleteLineItem(ArchivedLineItem lineItem) {
        synchronized(LOCK) {
            archivedLineItemRepository.delete(lineItem);
        }
    }

    public void deleteAllLineItems() {
        synchronized(LOCK) {
            archivedLineItemRepository.deleteAll();
        }
    }
}
