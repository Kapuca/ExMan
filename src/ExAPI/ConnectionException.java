package ExAPI;

public class ConnectionException extends Exception {
	// Parameterless Constructor
    public ConnectionException() {}

    // Constructor that accepts a message
    public ConnectionException(String message)
    {
       super(message);
    }
}
