package moonrise.ropecaguild2.api.exception;

public class MemberAlreadyExistException extends Exception {
	
	public MemberAlreadyExistException(String member) {
		super(member + " is already exist in this guild!");
	}
}
