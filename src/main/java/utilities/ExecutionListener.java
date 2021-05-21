package utilities;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pojo.TestStatus;

public class ExecutionListener implements ITestListener {

    private TestStatus testStatus;

    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //skip
    }



    private void sendStatus(ITestResult iTestResult, String status){
        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
        this.testStatus.setStatus(status);
        System.out.println(LocalDateTime.now().toString());
        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
        ResultSender.send(this.testStatus);
    }

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

}