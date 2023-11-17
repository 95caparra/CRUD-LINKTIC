package co.com.linktic.rest.common;

import co.com.linktic.model.exceptions.ModelException;
import co.com.linktic.rest.common.statuscode.StatusCode;
import co.com.linktic.rest.common.statuscode.StatusCodeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class HandlerControllerExceptions {

    @Autowired
    private StatusCodeConfig statusCodeConfig;


    /**
     * Handle error
     *
     * @param e exception
     * @return response
     */
    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ResponseCommand> exceptionHandler(Throwable e) {
        if(e.toString().contains(ConstantsHelper.PENDING_CONSTRAINT)){
            var statusCode = statusCodeConfig.of(ConstantsHelper.DUPLICATED_RECORD);
            return handlerError(e,ConstantsHelper.DUPLICATED_RECORD,statusCode,ConstantsHelper.DUPLICATED_RECORD);
        }
        return handlerError(e, null, null, null);
    }

    /**
     * Handler error
     *
     * @param e exception
     * @return response
     */
    @ExceptionHandler({ModelException.class})
    public ResponseEntity<ResponseCommand> modelExceptionHandler(ModelException e) {
        if (e.getError() == null) {
            return exceptionHandler(e);
        }
        var statusCode = statusCodeConfig.of(e.getError());
        return handlerError(e, e.getDefaultMessage(), statusCode, e.getDefaultMessage());
    }

    private ResponseEntity<ResponseCommand> handlerError(Throwable e,
                                                         String subMessage,
                                                         StatusCode statusCode,
                                                         String defaultMessage) {
        printMessage(e);
        var finalStatusCode = statusCode;
        if (finalStatusCode == null) {
            var statusCodes = StatusCodes.getByClass(e.getClass());
            finalStatusCode = statusCodeConfig.of(statusCodes.name());
        }
        var httpStatus = getHttpStatus(finalStatusCode);
        var message = getMessage(finalStatusCode, defaultMessage, subMessage);
        return ResponseEntity.ok(ResponseCommand.builder()
                .code(httpStatus)
                .message(message)
                .build());
    }

    public String getMessage(StatusCode statusCode, String defaultMessage, String subMessage) {
        var message = statusCode.getMessage();
        if (defaultMessage != null && statusCode.getCode().equalsIgnoreCase("99")) {
            message = defaultMessage;
        }

        if (subMessage != null) {
            message = message.concat(": ").concat(subMessage);
        }

        return message;
    }

    public void printMessage(Throwable e) {
        if (e.getMessage() != null) {
            log.info("{}: {}", e.getClass().getSimpleName(), e.getMessage());
        } else {
            log.info("{}", e.getClass().getSimpleName());
        }
    }

    /**
     * Get HttpStatus by statusCode
     *
     * @param statusCode status code
     * @return httpStatus
     */
    public String getHttpStatus(StatusCode statusCode) {
        try {
            var httpStatus = HttpStatus.resolve(Integer.parseInt(statusCode.getCode()));
            if (httpStatus == null) {
                return statusCode.getCode();
            }
            return String.valueOf(httpStatus.value());
        } catch (NumberFormatException e) {
            return statusCode.getCode();
        }
    }
}
