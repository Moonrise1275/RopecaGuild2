package moonrise.ropecaguild2.api.exception;

public class GuildNotExistException extends Exception {
	
	public GuildNotExistException(String guild) {
		super("Guid " + guild + " is not exist!");
	}
}
