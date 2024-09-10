package pdfgenerator;

import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final int COUNT_OPERATIONS = 15;
	private static final String CARD_NUMBER = "555000001";
	private static final String START_DATE = "2024-01-01";
	private static final String END_DATE = "2024-12-12";

	public static void main(String[] args) {

		List<Operation> operationList = generateOperations();

		createPdfInvoice(CARD_NUMBER, START_DATE, END_DATE, operationList);

	}

	private static List<Operation> generateOperations() {

		List<Operation> operationList = new ArrayList<>();
		for (int i = 0; i < Main.COUNT_OPERATIONS; i++) {
			operationList.add(new Operation());
		}

		return operationList;
	}

	public static void createPdfInvoice(String cardNumber,
	                                    String startDate,
	                                    String endDate,
	                                    List<Operation> operations) {

		File directory = new File("src/main/java/pdfgenerator");
		if (!directory.exists() && !directory.mkdir()) {
			throw new RuntimeException("Failed to create directory for PDF generation");
		}

		File pdfFile = new File(directory, "report.pdf");
		try (FileOutputStream fos = new FileOutputStream(pdfFile)) {

			String html = generateHtml(cardNumber, startDate, endDate, operations);
			HtmlConverter.convertToPdf(html, fos);

			System.out.println("PDF файл сохранен в: " + pdfFile.getAbsolutePath());

		} catch (IOException exception) {
			throw new RuntimeException("Error creating PDF report", exception);
		}
	}

	private static String generateHtml(String cardNumber, String startDate, String endDate, List<Operation> operations)
			throws IOException {
		// Загружаем HTML-шаблон из ресурсов
		InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("report-template.html");
		if (inputStream == null) {
			throw new IOException("HTML template not found");
		}

		String htmlTemplate = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

		// Формируем строки для операций
		StringBuilder operationsHtml = new StringBuilder();
		double totalAmount = 0;
		for (Operation operation : operations) {
			operationsHtml.append("<tr>")
			              .append("<td>")
			              .append(operation.getDate())
			              .append("</td>")
			              .append("<td>")
			              .append(operation.getStation())
			              .append("</td>")
			              .append("<td>")
			              .append(operation.getGasStationId())
			              .append("</td>")
			              .append("<td>")
			              .append(operation.getQuantity())
			              .append("</td>")
			              .append("<td>")
			              .append(String.format("%.2f", operation.getPrice()))
			              .append("</td>")
			              .append("<td>")
			              .append(String.format("%.2f", operation.getTotal()))
			              .append("</td>")
			              .append("</tr>");
			totalAmount += operation.getTotal();
		}

		// Форматирование текущей даты
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		String generatedDate = LocalDateTime.now().format(dateTimeFormatter);

		// Заменяем плейсхолдеры в шаблоне

		return htmlTemplate.replace("{generatedDate}", generatedDate)
		                   .replace("{cardNumber}", cardNumber)
		                   .replace("{startDate}", startDate)
		                   .replace("{endDate}", endDate)
		                   .replace("{operations}", operationsHtml.toString())
		                   .replace("{totalAmount}", String.format("%.2f", totalAmount));
	}

	//	public static String createPdfInvoiceBase64(String cardNumber, String startDate, String endDate, List<Operation> operations) {
//		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//			String html = generateHtml(cardNumber, startDate, endDate, operations);
//
//			HtmlConverter.convertToPdf(html, baos);
//			return Base64.getEncoder().encodeToString(baos.toByteArray());
//		} catch (IOException ex) {
//			throw new RuntimeException("Error creating pdf report base64", ex);
//		}
//	}
}
