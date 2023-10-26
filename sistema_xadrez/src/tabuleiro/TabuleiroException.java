package tabuleiro;

public class TabuleiroException extends RuntimeException{
	private static final long versaoSerialUID=1L;
	
	public TabuleiroException(String msg) {
		super(msg);
	}
}
