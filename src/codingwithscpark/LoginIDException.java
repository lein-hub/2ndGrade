package codingwithscpark;

public class LoginIDException extends LoginException {
	public LoginIDException (String errMsg) {
		super(errMsg);
	}

	public LoginIDException (String errMsg, int errCode) {
		super(errMsg, errCode);
	}
}
