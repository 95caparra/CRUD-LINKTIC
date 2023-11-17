package co.com.linktic.rest.exceptions;
import co.com.linktic.model.exceptions.ModelException;
public class RequestDtoValidationException  extends ModelException {

    public RequestDtoValidationException(String error, String defaultMessage) {
        super(error, defaultMessage);
    }
}
