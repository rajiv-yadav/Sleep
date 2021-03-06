package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class TestUtil extends TestBase {

	public static String destDir;
	public static DateFormat dateFormat;
	public static String destFile;
	public static String mailscreenshotpath;

	public static Object[][] getData(String sheetName) {

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[rowNum-2][colNum]= excel.getCellData(sheetName, colNum,
				// rowNum);

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;

			}

		}

		return data;

	}

	
	public static void takeScreenShot() throws IOException {

		// directory
		destDir = "test-output/html";

		// capturing screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Set date
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		// create folder
		new File(destDir).mkdir();

		destFile = dateFormat.format(new Date()) + ".png";
		mailscreenshotpath = destDir + "/" + destFile;
		System.out.println(" mailscreenshotpath : "+mailscreenshotpath);
		FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));

	}

	
	public static String elementScreenshot(WebElement ele) {

		File screenshotLocation = null;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			BufferedImage fullImg = ImageIO.read(scrFile);
			// Get the location of element on the page
			Point point = ele.getLocation();
			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);

			String fileName = "newscreenshot";

			screenshotLocation = new File("./screenshots/" + fileName + ".jpg");
			FileUtils.copyFile(scrFile, screenshotLocation);

			System.out.println(screenshotLocation.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotLocation.toString();

	}

}
