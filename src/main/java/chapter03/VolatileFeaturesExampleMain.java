package chapter03;

public class VolatileFeaturesExampleMain {
	public static void main(String[] args) throws Exception {
		VolatileFeaturesExample example=new VolatileFeaturesExample();
		for (int j = 0; j < 100; j++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						example.getAndIncrement();				
					}
				}
			}).start();
		}
		Thread.sleep(2000);
		System.out.println(example.get());
	}
}
