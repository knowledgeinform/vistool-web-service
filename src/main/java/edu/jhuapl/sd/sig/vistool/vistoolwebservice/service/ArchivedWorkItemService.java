package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.WorkItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.AbstractWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ArchivedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ArchivedWorkItemRepository;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ArchivedWorkItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;

public class ArchivedWorkItemService {
    @Autowired ArchivedWorkItemRepository archivedWorkItemRepository;
    @Autowired WorkItemHydrationLogic workItemHydrationLogic;
    
    private final Object LOCK = new Object();

    public List<ArchivedWorkItem> getAllWorkItemsWithMaxVersion() {
        return archivedWorkItemRepository.findAll(
            where(versionMaximum())
        );
    }

    public Optional<ArchivedWorkItem> getWorkItemWithMaxVersionById(Long id) {
        return archivedWorkItemRepository.findOne(
            where(
                versionMaximum()
                .and(idEqualTo(id))
            )
        );
    }

    public List<HydratedWorkItem> getAllHydratedWorkItemsWithMaxVersion() {
        List<ArchivedWorkItem> workItems = getAllWorkItemsWithMaxVersion();
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<AbstractWorkItem>(workItems));
    }

    public Optional<HydratedWorkItem> getHydratedWorkItemWithMaxVersionById(Long id) {
        Optional<ArchivedWorkItem> optionalWorkItem = getWorkItemWithMaxVersionById(id);
        if(optionalWorkItem.isPresent()) {
            HydratedWorkItem hydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(optionalWorkItem.get());
            return Optional.of(hydratedWorkItem);
        }
        return Optional.empty();
    }

    public List<ArchivedWorkItem> getAllWorkItemVersionsById(Long id) {
        return archivedWorkItemRepository.findAll(
            where(
                idEqualTo(id)
            )
        );
    }

    public List<ArchivedWorkItem> getAllWorkItemsByParentLineItem(LineItem parentLineItem) {
        return archivedWorkItemRepository.findAll(
            where(parentLineItemEqualTo(parentLineItem))
        );
    }

    public List<HydratedWorkItem> getHydratedWorkItems(List<AbstractWorkItem> workItems) {
        return workItemHydrationLogic.hydrateWorkItems(workItems);
    }

    public HydratedWorkItem getHydratedWorkItem(WorkItem workItem) {
        return workItemHydrationLogic.hydrateWorkItem(workItem);
    }

    public List<HydratedWorkItem> getAllHydratedWorkItemVersionsById(Long id) {
        List<ArchivedWorkItem> workItems = getAllWorkItemVersionsById(id);
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<AbstractWorkItem>(workItems));
    }

    // TODO: Consider removing
    public List<HydratedWorkItem> getAllHydratedWorkItemsByParentLineItem(LineItem parentLineItem) {
        List<ArchivedWorkItem> workItems = getAllWorkItemsByParentLineItem(parentLineItem);
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<AbstractWorkItem>(workItems));
    }

    public ArchivedWorkItem saveWorkItem(AbstractWorkItem workItem) {
        synchronized(LOCK) {
            return archivedWorkItemRepository.save((ArchivedWorkItem) workItem);
        }
    }

    public List<ArchivedWorkItem> saveWorkItems(List<WorkItem> workItems) {
        List<ArchivedWorkItem> savedWorkItems = new ArrayList<>();
        for(WorkItem workItem : workItems) {
            savedWorkItems.add(saveWorkItem(workItem));
        }
        return savedWorkItems;
     }
 
     public void deleteWorkItem(ArchivedWorkItem workItem) {
         synchronized(LOCK) {
             archivedWorkItemRepository.delete(workItem);
         }
     }
 
     public void deleteAllWorkItems() {
         synchronized(LOCK) {
             archivedWorkItemRepository.deleteAll();
         }
     }
}
