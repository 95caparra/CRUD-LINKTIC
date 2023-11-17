package co.com.linktic.model.exceptions;
import co.com.linktic.model.enums.Process;

public class ValidateCustomerException extends ModelException{

    public ValidateCustomerException(Process process, String error){
        super(process.name(),error);
    }
    public ValidateCustomerException(String process, String error){
        super(process,error);
    }

    public ValidateCustomerException( String error){
        super(error,error);
    }

}
