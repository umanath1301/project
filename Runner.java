package comexcelwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Runner {
public static  ExtentTest test;
public static ExtentReports report;
public static final Logger logger=LogManager.getLogger(Runner.class);

@BeforeClass
public static void starttest() throws FileNotFoundException, IOException {
File file=new File("C:\\Users\\VISWA SYSTEMS\\workspace\\logging.log");
file.delete();
Properties props=new Properties();
props.load(new FileInputStream("log4j.properties"));
PropertyConfigurator.configure(props);
report=new ExtentReports(System.getProperty("user.div")+"\\ExtendReportsText.html");
report.assignProject("excelwrite");

}
@Test
public void testcase1() throws IOException {
	test=report.startTest("cricbuzz");
	logger.info("first testxcase started");
	PointTable point=new PointTable();
	point.table();
}
@AfterClass
public static void endtest() {
	report.flush();
	report.endTest(test);
	
	
	
}

}