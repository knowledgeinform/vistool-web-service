package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PickAndPlace {
	private Boolean pickAndPlaceBool;
	@Enumerated(EnumType.STRING)
	private LoadingPriorities loadingPriorities;
	private String sizeAndMagazines;
	private String pickAndPlaceNotes;
	private Date targetStartDate;

	public PickAndPlace(PickAndPlace source) {
		this(source.getPickAndPlaceBool(),
			 source.getLoadingPriorities(),
			 source.getSizeAndMagazines(),
			 source.getPickAndPlaceNotes(),
			 source.getTargetStartDate() == null ? null : new Date(source.getTargetStartDate().getTime())
		);
	}
}
