package converters;

import entities.Endereço;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Endereço.class)
@Named
public class EndereçoConverter extends EntityConverter<Endereço>{
    
    public EndereçoConverter() {
        super(Endereço.class);
    }
}
