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

public class DesafioFirefox02 {

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
		WebElement openCategoriesDrinks = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesDrinks.getText().contains("Selecione a Categoria"));
		openCategoriesDrinks.click();
		snapshot("Snapshot_2");

		WebElement selectDrinks = driver.findElement(By.id("category-0"));
		assertTrue(selectDrinks.getText().contains("Bebidas"));
		selectDrinks.click();
		snapshot("Snapshot_3");

		WebElement addProductCoca = driver.findElement(By.id("add-product-0-btn"));
		assertTrue(addProductCoca.getText().contains("Adicionar ao carrinho"));
		addProductCoca.click();
		snapshot("Snapshot_4");
		
		WebElement addProductFanta = driver.findElement(By.id("add-product-1-btn"));
		assertTrue(addProductFanta.getText().contains("Adicionar ao carrinho"));
		addProductFanta.click();
		snapshot("Snapshot_5");
		
		WebElement addProductAgua = driver.findElement(By.id("add-product-2-btn"));
		assertTrue(addProductAgua.getText().contains("Adicionar ao carrinho"));
		addProductAgua.click();
		snapshot("Snapshot_6");
		
		WebElement openCategoriesAll = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesAll.getText().contains("Bebidas"));
		openCategoriesAll.click();
		snapshot("Snapshot_7");
		
		WebElement selectCategoriesAll = driver.findElement(By.id("category-all"));
		assertTrue(selectCategoriesAll.getText().contains("Todos"));
		selectCategoriesAll.click();
		snapshot("Snapshot_8");
		
		WebElement addProductRissole = driver.findElement(By.id("add-product-3-btn"));
		assertTrue(addProductRissole.getText().contains("Adicionar ao carrinho"));
		addProductRissole.click();
		snapshot("Snapshot_9");
		
		WebElement cart = driver.findElement(By.id("cart-btn"));
		cart.click();
		snapshot("Snapshot_10");
		
		for (int i = 1; i <= 9; i++) {
			snapshot("Snapshot_" + (10 + i));
			WebElement increase = driver.findElement(By.id("add-product-3-qtd"));
			increase.click();
		}
		snapshot("Snapshot_21");
		
		for (int i = 10; i > 5; i--) {
			snapshot("Snapshot_" + (41 - ((i+10))));
			WebElement decrease = driver.findElement(By.id("remove-product-3-qtd"));
			decrease.click();
		}
		
		WebElement totalValue = driver.findElement(By.id("price-total-checkout"));
		assertTrue(totalValue.getText().contains("R$ 36,00"));
		snapshot("Snapshot_26");
		
		WebElement finish = driver.findElement(By.id("finish-checkout-button"));
		finish.click();
		snapshot("Snapshot_27");

		WebElement finishRequest = driver.findElement(By.className("jyncPa"));
		assertEquals(finishRequest.getText(), ("Pedido realizado com sucesso!"));
		snapshot("Snapshot_28");

		WebElement close = driver.findElement(By.className("ippulb"));
		close.click();
		snapshot("Snapshot_29");

	}

	public void snapshot(String fileName) throws Exception {

		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Image\\Desafio02\\" + fileName + ".jpg");
		FileUtils.copyFile(screenShotFile, destFile);

	}
}
