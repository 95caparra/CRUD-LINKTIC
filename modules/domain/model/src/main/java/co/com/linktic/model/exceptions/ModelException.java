package co.com.linktic.model.exceptions;

import lombok.Getter;

@Getter
public class ModelException extends Exception {

    private final String error;
    private final String defaultMessage;

    public ModelException(String errorI, String defaultMessageI) {
        this.error = errorI;
        this.defaultMessage = defaultMessageI;
    }

    public ModelException() {
        this.error = null;
        this.defaultMessage = null;
    }

    public ModelException(Throwable e) {
        super(e);
        this.error = null;
        this.defaultMessage = null;
    }
}
