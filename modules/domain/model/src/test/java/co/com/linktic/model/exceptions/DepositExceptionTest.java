package co.com.linktic.model.exceptions;


import co.com.linktic.model.enums.Process;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
class DepositExceptionTest {

    @InjectMocks
    private DepositException depositException;


    @Test
    void testConstructorWithProcessAndError() {
        // Arrange
        Process process = Process.DEPOSIT;
        String error = "Sample error message";

        // Act
        depositException = new DepositException(process, error);

        // Assert
        Assertions.assertNotNull(depositException);
        //Assertions.assertEquals(process, depositException.getProcess());
        Assertions.assertEquals(error, depositException.getDefaultMessage());
    }

    @Test
    void testConstructorWithProcessAndErrorString() {
        // Arrange
        Process process = Process.DEPOSIT;
        String error = "Sample error message";

        // Act
        depositException = new DepositException(process, error);

        // Assert
        Assertions.assertNotNull(depositException);
        Assertions.assertEquals(error, depositException.getDefaultMessage());
    }

    @Test
    void testConstructorWithError() {
        // Arrange
        String error = "Sample error message";

        // Act
        depositException = new DepositException(error);

        // Assert
        Assertions.assertNotNull(depositException);
        //Assertions.assertNull(depositException.getProcess()); // No process specified
        Assertions.assertEquals(error, depositException.getDefaultMessage());
    }
}
