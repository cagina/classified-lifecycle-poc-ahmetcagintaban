package sahininden.com.classified.lifecycle.poc.model;

public class StatisticsResponse {
	private long aktifCount;
	private long deaktifCount;
	private long onayCount;

	public long getAktifCount() {
		return aktifCount;
	}

	public void setAktifCount(long aktifCount) {
		this.aktifCount = aktifCount;
	}

	public long getDeaktifCount() {
		return deaktifCount;
	}

	public void setDeaktifCount(long deaktifCount) {
		this.deaktifCount = deaktifCount;
	}

	public long getOnayCount() {
		return onayCount;
	}

	public void setOnayCount(long onayCount) {
		this.onayCount = onayCount;
	}

	public StatisticsResponse(long aktifCount, long deaktifCount, long onayCount) {
		this.aktifCount = aktifCount;
		this.deaktifCount = deaktifCount;
		this.onayCount = onayCount;
	}
	public StatisticsResponse() {};

}
