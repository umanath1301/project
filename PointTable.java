package comexcelwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PointTable {
	public static void table() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://m.cricbuzz.com/cricket-series/3472/indian-premier-league-2021/points-table");
		driver.manage().window().maximize();
		Runner.logger.info("app is launched");
	
		List l1=driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/table/thead/tr/th"));
		System.out.println("col"+l1.size());
		List row=driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody"));
		System.out.println("row"+row.size());
	String file="E:\\New folder\\msd.xlsx";
	FileInputStream file1=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(file1);
	XSSFSheet sheet=book.getSheet("num");
	XSSFRow row1=sheet.getRow(0);
	Runner.logger.info("1");
		int rowcount=sheet.getLastRowNum();
		for(int i=1;i<=row.size();i++) {
		String max1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[1]")).getText();
		String max2=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[2]")).getText();
		String max3=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[3]")).getText();
		String max4=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[4]")).getText();
		String max5=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[5]")).getText();
		String max6=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/table/tbody["+i+"]/tr/td[6]")).getText();
		System.out.println(max1);
		System.out.println(max2);
		System.out.println(max3);
		System.out.println(max4);
		System.out.println(max5);
		System.out.println(max6);
		Row row2=sheet.createRow(i);
		row2.createCell(0).setCellValue(max1);
		row2.createCell(1).setCellValue(max2);
		row2.createCell(2).setCellValue(max3);
		row2.createCell(3).setCellValue(max4);
		row2.createCell(4).setCellValue(max5);
		row2.createCell(5).setCellValue(max6);
		
		}
	
		driver.close();
		String file2="E:\\New folder\\poin6.xlsx";
		FileOutputStream fileout=new FileOutputStream(file2);
		book.write(fileout);
		fileout.close();

}
	
}
