package converters;

import entities.Teatro;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Teatro.class)
@Named
public class TeatroConverter extends EntityConverter<Teatro>{
    
    public TeatroConverter() {
        super(Teatro.class);
    }
}
