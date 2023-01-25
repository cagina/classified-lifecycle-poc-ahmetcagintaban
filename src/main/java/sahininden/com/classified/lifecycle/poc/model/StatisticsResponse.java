package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;
@ApiModel(value ="Ilan İstatiksel Durum Modeli", description ="İlanlar içerisinde oluşan bütün istatistikleri dönen model yani aktif, deaktif, onayda bekleyen.")
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

	@Override
	public String toString() {
		return "StatisticsResponse{" +
				"aktifCount=" + aktifCount +
				", deaktifCount=" + deaktifCount +
				", onayCount=" + onayCount +
				'}';
	}
}
