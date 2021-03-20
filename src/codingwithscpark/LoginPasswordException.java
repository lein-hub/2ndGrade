package codingwithscpark;

public class LoginPasswordException extends LoginException {

	private static final long serialVersionUID = 1L;
	
	public LoginPasswordException (String errMsg) {
		super(errMsg);
	}

	public LoginPasswordException (String errMsg, int errCode) {
		super(errMsg, errCode);
	}
}
