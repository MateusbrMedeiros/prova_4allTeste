package com.medeiros.prova_4all;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

public class DesafioFirefox01 {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mateu\\Documents\\Dev\\Gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://shopcart-challenge.4all.com/");
		driver.manage().window().maximize();
	}

	@After
	public void finish() {
		driver.quit();

	}

	@Test
	public void selectProducts() throws Exception {
		
		snapshot("Snapshot_1");
		WebElement openCategoriesCandies = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesCandies.getText().contains("Selecione a Categoria"));
		openCategoriesCandies.click();
		snapshot("Snapshot_2");

		WebElement selectCandies = driver.findElement(By.id("category-1"));
		assertTrue(selectCandies.getText().contains("Doces"));
		selectCandies.click();
		snapshot("Snapshot_3");

		WebElement addProductBrigadeiro = driver.findElement(By.id("add-product-4-btn"));
		assertTrue(addProductBrigadeiro.getText().contains("Adicionar ao carrinho"));
		addProductBrigadeiro.click();
		snapshot("Snapshot_4");

		WebElement addProductAlfajor = driver.findElement((By.id("add-product-5-btn")));
		assertTrue(addProductAlfajor.getText().contains("Adicionar ao carrinho"));
		addProductAlfajor.click();
		snapshot("Snapshot_5");

		WebElement openCategoriesAll = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesAll.getText().contains("Doces"));
		openCategoriesAll.click();
		snapshot("Snapshot_6");

		WebElement selectCandiesAll = driver.findElement(By.id("category-all"));
		assertTrue(selectCandiesAll.getText().contains("Todos"));
		selectCandiesAll.click();
		snapshot("Snapshot_7");

		WebElement cart = driver.findElement(By.id("cart-btn"));
		cart.click();

		for (int i = 1; i < 4; i++) {
			snapshot("Snapshot_" + (7 + i));
			WebElement increase = driver.findElement(By.id("add-product-4-qtd"));
			increase.click();
		}
		snapshot("Snapshot_11");
		
		WebElement finish = driver.findElement(By.id("finish-checkout-button"));
		finish.click();
		snapshot("Snapshot_12");

		WebElement finishRequest = driver.findElement(By.className("jyncPa"));
		assertEquals(finishRequest.getText(), ("Pedido realizado com sucesso!"));

		WebElement close = driver.findElement(By.className("ippulb"));
		close.click();
		snapshot("Snapshot_13");

	}

	public void snapshot(String fileName) throws Exception {

		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Image\\Desafio01\\" + fileName + ".jpg");
		FileUtils.copyFile(screenShotFile, destFile);

	}

}
