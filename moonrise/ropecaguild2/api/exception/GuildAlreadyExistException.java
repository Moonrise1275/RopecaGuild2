package moonrise.ropecaguild2.api.exception;

public class GuildAlreadyExistException extends Exception {
	
	public GuildAlreadyExistException(String guild) {
		super("Guild " + " is already exist!");
	}
}
