
public class TestThread extends Thread {

	private int x;
	private int y;
	private ThreadCallback callback;
	
	public TestThread(int x, int y, ThreadCallback callback) {
		this.x = x;
		this.y = y;
		this.callback = callback;
	}
	
	@Override
	public void run() {
		int result = x + y;
		this.callback.onResult(result);
	}
	
	public static interface ThreadCallback {
		public void onResult(int result);
	}
}
