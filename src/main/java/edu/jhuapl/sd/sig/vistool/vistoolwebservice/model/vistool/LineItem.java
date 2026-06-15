package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "line_item")
@IdClass(PrimaryKey.class)
@AllArgsConstructor
public class LineItem extends AbstractLineItem implements Serializable {
    
    public LineItem(Long id, Long version, String workAuthorizationNumber, String lineItemNumber, Integer quantity,
            Date workAuthorizationChangeStopDate, Date workAuthorizationChangeTADate, Date modifiedDate) {
                this.setId(id);
                this.setVersion(version);
                this.setWorkAuthorizationNumber(workAuthorizationNumber);
                this.setLineItemNumber(lineItemNumber);
                this.setQuantity(quantity);
                this.setWorkAuthorizationChangeStopDate(workAuthorizationChangeStopDate);
                this.setWorkAuthorizationChangeTADate(workAuthorizationChangeTADate);
                this.setModifiedDate(modifiedDate);
    }
}
