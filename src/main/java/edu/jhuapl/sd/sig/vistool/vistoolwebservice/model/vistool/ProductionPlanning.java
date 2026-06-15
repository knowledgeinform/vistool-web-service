package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ProductionPlanning {
	private boolean productionPlanning;
	private String productionPlanningNotes;
	private String actionItems;

	public ProductionPlanning(ProductionPlanning source) {
		this(source.isProductionPlanning(),
			 source.getProductionPlanningNotes(),
			 source.getActionItems()
		);
	}
}
