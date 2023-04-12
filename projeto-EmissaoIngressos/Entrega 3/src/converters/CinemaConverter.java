package converters;

import entities.Cinema;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Cinema.class)
@Named
public class CinemaConverter extends EntityConverter<Cinema>{
    
    public CinemaConverter() {
        super(Cinema.class);
    }
}
