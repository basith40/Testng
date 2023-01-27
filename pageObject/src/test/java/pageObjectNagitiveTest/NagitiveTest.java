package pageObjectNagitiveTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectBaseTest.PageBase;

public class NagitiveTest extends PageBase{
	@Test
	public void login() throws IOException {
		browserSelect();
		System.out.println("Bismillah");
	}

}
