package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV(int chnanel, int volume, boolean power) {
		this.channel = chnanel;
		this.volume = volume;
		this.power = power;
	}

	public int getChaanel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power:" + (power ? "ON" : "OFF") + "]");
	}

	public void power(boolean on) {
		power = on ? true : false;
	}

	public void channel(int channel) {
		if(!power) {
			return;
		}
		
		if (channel < 0) {
			this.channel = 255;
		} else if (channel > 255) {
			this.channel = 0;
		} else {
			this.channel = channel;
		}
	}

	public void channel(boolean up) {
		channel(channel + (up ? 1 : -1));
	}

	public void volume(int volume) {
		if(!power) {
			return;
		}
		
		if (volume < 0) {
			this.volume = 100;
		} else if (volume > 100) {
			this.volume = 0;
		} else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}
}
