package moonrise.ropecaguild2.api.exception;

public class UnauthorizedUserException extends Exception {
	
	public UnauthorizedUserException(String user, String act) {
		super("This user can't do this : " + act);
	}
}
