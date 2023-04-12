package converters;

import entities.Ingresso;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Ingresso.class)
@Named
public class TeatroConverter extends EntityConverter<Ingresso>{
    
    public TeatroConverter() {
        super(Ingresso.class);
    }
}
