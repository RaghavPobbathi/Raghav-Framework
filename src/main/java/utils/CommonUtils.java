package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtils {

	public static Properties loadProperties() {
		Properties prop = new Properties();
		FileReader fr;
		try {
			fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\ProjectData.properties");
			prop.load(fr);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}

	public static String generateNewEmail() {

		return System.currentTimeMillis() + "@gmail.com";
	}

	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) {

		MyXLSReader xls = xls_received;

		String testCaseName = testName;

		String testDataSheet = sheetName;

		int testStartRowNumber = 1;

		while (!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))) {

			testStartRowNumber++;

		}

		int columnStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;

		int rows = 0;
		while (!(xls.getCellData(testDataSheet, 1, dataStartRowNumber + rows).equals(""))) {

			rows++;

		}

		// Total number of columns in the required test
		int columns = 1;

		while (!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))) {

			columns++;

		}

		Object[][] obj = new Object[rows][1];

		HashMap<String, String> map = null;

		// Reading the data in the test
		for (int i = 0, row = dataStartRowNumber; row < dataStartRowNumber + rows; row++, i++) {

			map = new HashMap<String, String>();

			for (@SuppressWarnings("unused")
			int j = 0, column = 1; column < columns; column++, j++) {

				String key = xls.getCellData(testDataSheet, column, columnStartRowNumber);

				String value = xls.getCellData(testDataSheet, column, row);

				map.put(key, value);

			}

			obj[i][0] = map;

		}

		return obj;

	}
	
	public static ExtentReports getExtentReports() {
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html");
		ExtentSparkReporterConfig sparkReporterConfig = sparkReporter.config();
		sparkReporterConfig.setReportName("tutorialsNinja Result Report");
		sparkReporterConfig.setDocumentTitle("TN Report");
		
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("username", System.getProperty("user.name"));
		extentReports.setSystemInfo("selenium version", "4.28.0");
		extentReports.setSystemInfo("java version", System.getProperty("java.version"));
		extentReports.setSystemInfo("OS", System.getProperty("user.os"));
		
		return extentReports;
	}

}
