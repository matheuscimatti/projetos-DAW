package converters;

import entities.ClasseShow;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = ClasseShow.class)
@Named
public class ShowConverter extends EntityConverter<ClasseShow>{
    
    public ShowConverter() {
        super(ClasseShow.class);
    }
}
