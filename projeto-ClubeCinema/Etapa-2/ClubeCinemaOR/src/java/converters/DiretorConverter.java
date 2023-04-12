package converters;

import entities.Diretor;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Diretor.class)
@Named
public class DiretorConverter extends EntityConverter<Diretor>{
    
    public DiretorConverter() {
        super(Diretor.class);
    }
}
