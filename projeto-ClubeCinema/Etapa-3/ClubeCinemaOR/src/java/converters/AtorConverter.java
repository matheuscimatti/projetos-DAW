package converters;

import entities.Ator;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Ator.class)
@Named
public class AtorConverter extends EntityConverter<Ator>{
    
    public AtorConverter() {
        super(Ator.class);
    }
}
