
package converters;

import entities.Amigo;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;


@FacesConverter(forClass = Amigo.class)
@Named
public class AmigoConverter extends EntityConverter<Amigo> {
    
    public AmigoConverter() {
        super(Amigo.class);
    }
}
