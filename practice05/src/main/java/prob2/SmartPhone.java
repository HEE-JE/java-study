package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {
		if (function.equals("앱")) {
			App();
			return;
		}
		super.execute(function);
	}

	public void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}

	private void App() {
		System.out.println("앱실행");
	}
}