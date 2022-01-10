package ex01.exception;


@SuppressWarnings("serial")
public class DuplicateMemberException extends Exception {
	public DuplicateMemberException(String message) {
		super(message);
	}
}
