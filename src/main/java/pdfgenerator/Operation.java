package pdfgenerator;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Operation {

	private LocalDateTime date;
	private String station;
	private String gasStationId;
	private Double quantity;
	private Double price;
	private Double total;

	public Operation() {
		this.date = LocalDateTime.parse("2024-05-05T00:00:00");
		this.station = "8787";
		this.gasStationId = "test service";
		this.quantity = getRandomDouble(10.00, 100.00);
		this.price = getRandomDouble(10.00, 100.00);
		this.total = this.quantity * this.price;
	}

	// Метод для генерации случайного значения в диапазоне
	private Double getRandomDouble(double min, double max) {
		return ThreadLocalRandom.current().nextDouble(min, max);
	}
}
