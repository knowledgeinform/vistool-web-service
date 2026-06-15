package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.ColumnLayoutException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ColumnLayoutRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnLayoutService {
    @Autowired private ColumnLayoutRepository columnLayoutRepository;

    public ColumnLayout addColumnLayout(ColumnLayout columnLayout) {
        // Set creation date
        columnLayout.setDateCreated(new Date(System.currentTimeMillis()));
        return columnLayoutRepository.save(columnLayout);
    }

    public List<ColumnLayout> findAllColumnLayoutsByUserId(@NonNull String userId) {
        return columnLayoutRepository.findAll(
                Specification.where(
                        ColumnLayoutRepository.userIdEqualTo(userId)
                )
        );
    }

    public List<ColumnLayout> findAllColumnLayoutsByVisibility(@NonNull boolean visible) {
        return columnLayoutRepository.findAll(
                Specification.where(
                        ColumnLayoutRepository.matchesVisibility(visible)
                )
        );
    }

    public Optional<ColumnLayout> findOneColumnLayoutById(@NonNull int id) {
        return columnLayoutRepository.findOne(
                Specification.where(
                        ColumnLayoutRepository.columnLayoutIdEqualTo(id)
                )
        );
    }

    public ColumnLayout updateColumnLayoutName(@NonNull int id, String updatedName) throws ColumnLayoutException {
        Optional<ColumnLayout> origColLayout = findOneColumnLayoutById(id);
        // if present, update the name
        if (origColLayout.isPresent()) {
            ColumnLayout updatedColLayout = origColLayout.get();
            updatedColLayout.setName(updatedName);
            return columnLayoutRepository.save(updatedColLayout);
        } else {
            throw new ColumnLayoutException(String.format("Could not find column layout with ID %d to update.", id));
        }
    }

    public ColumnLayout updateColumnLayoutVisibility(@NonNull int id, boolean visibile) throws ColumnLayoutException {
        Optional<ColumnLayout> origColLayout = findOneColumnLayoutById(id);
        // if present, update the name
        if (origColLayout.isPresent()) {
            ColumnLayout updatedColLayout = origColLayout.get();
            updatedColLayout.setVisible(visibile);
            return columnLayoutRepository.save(updatedColLayout);
        } else {
            throw new ColumnLayoutException(String.format("Could not find column layout with ID %d to update.", id));
        }
    }

}
