package chapter09.code;

public class TV9_3 {
	int channel = 1;
	int volumeLevel = 1;
	boolean on = false;

	public TV9_3() {
	}

	public void turnOn() {
		on = true;
	}

	public void turnOff() {
		on = false;
	}

	public void setChannel(int newChannel) {
		if (on && newChannel >= 1 && newChannel <= 120) {
			channel = newChannel;
		}
	}

	public void setVolume(int newVolumeleve) {
		if (on && newVolumeleve >= 1 && newVolumeleve <= 120) {
			channel = newVolumeleve;
		}
	}

	public void channelUp() {
		if (on && channel < 120) {
			channel++;
		}
	}

	public void channelDown() {
		if (on && channel > 1) {
			channel--;
		}
	}

	public void VolumeUp() {
		if (on && volumeLevel < 7) {
			volumeLevel++;
		}
	}

	public void VolumeDown() {
		if (on && volumeLevel > 1) {
			volumeLevel--;
		}
	}

}
