package co.com.linktic.model.exceptions;

import co.com.linktic.model.enums.Process;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class ValidateCustomerExceptionTest {

    @InjectMocks
    private ValidateCustomerException validateCustomerException;

    @Test
    void testConstructorWithProcessAndError() {
        // Arrange
        Process process = Process.DEPOSIT;
        String error = "Sample error message";

        // Act
        validateCustomerException = new ValidateCustomerException(process, error);

        // Assert
        Assertions.assertNotNull(validateCustomerException);
        //Assertions.assertEquals(process, depositException.getProcess());
        Assertions.assertEquals(error, validateCustomerException.getDefaultMessage());
    }

    @Test
    void testConstructorWithProcessAndErrorString() {
        // Arrange
        Process process = Process.DEPOSIT;
        String error = "Sample error message";

        // Act
        validateCustomerException = new ValidateCustomerException(process, error);

        // Assert
        Assertions.assertNotNull(validateCustomerException);
        Assertions.assertEquals(error, validateCustomerException.getDefaultMessage());
    }

    @Test
    void testConstructorWithError() {
        // Arrange
        String error = "Sample error message";

        // Act
        validateCustomerException = new ValidateCustomerException(error);

        // Assert
        Assertions.assertNotNull(validateCustomerException);
        //Assertions.assertNull(depositException.getProcess()); // No process specified
        Assertions.assertEquals(error, validateCustomerException.getDefaultMessage());
    }


}
