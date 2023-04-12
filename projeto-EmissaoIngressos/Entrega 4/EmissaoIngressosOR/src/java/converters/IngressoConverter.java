package converters;

import entities.Ingresso;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Ingresso.class)
@Named
public class IngressoConverter extends EntityConverter<Ingresso>{
    
    public IngressoConverter() {
        super(Ingresso.class);
    }
}
