package co.com.linktic.model.exceptions;

import co.com.linktic.model.enums.Process;

public class DepositException extends ModelException {

    public static final String MAX_LIMIT_RECHARGE = "MAX_LIMIT_RECHARGE";
    public static final String DEPOSIT = "DEPOSIT";

    public DepositException(Process process, String error){
        super(process.name(),error);
    }

    public DepositException(String process, String error){
        super(process,error);
    }

    public DepositException( String error){
        super(error,error);
    }
}
