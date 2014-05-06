package moonrise.ropecaguild2.api.exception;

public class MemberNotExistException extends Exception {
	
	public MemberNotExistException(String guild, String member) {
		super(member + " is not a member of " + guild);
	}
}
