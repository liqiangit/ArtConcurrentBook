package chapter03;

/**
 * <p>
 * 如果主线程包含非守护进程的线程，那么线程不运行完成，主线程是不会停止的
 * </p>
 * <p>
 * 测试方法：去掉volatile，main方法不会自动停
 * </p>
 * 
 * @author liqiang
 *
 */
public class VolatileDemo1 {
	private static volatile boolean isOver = false;

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(isOver);
			}
		});
		thread.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isOver = true;
	}
}