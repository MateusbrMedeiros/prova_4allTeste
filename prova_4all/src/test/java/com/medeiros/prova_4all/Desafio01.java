package com.medeiros.prova_4all;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desafio01 {

	
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://shopcart-challenge.4all.com/");
//		driver.manage().window().maximize();
	}
	
	@After
	public void finish() {
		driver.quit();
		
	}
	
	@Test
	public void selectCandies() {
		
		WebElement openCategoriesCandies = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesCandies.getText().contains("Selecione a Categoria"));
		openCategoriesCandies.click();
		
		WebElement selectCandies = driver.findElement(By.id("category-1"));
		assertTrue(selectCandies.getText().contains("Doces"));
		selectCandies.click();
		
		WebElement addProductBrigadeiro = driver.findElement(By.id("add-product-4-btn"));
		assertTrue(addProductBrigadeiro.getText().contains("Adicionar ao carrinho"));
		addProductBrigadeiro.click();
		
		WebElement addProductAlfajor = driver.findElement((By.id("add-product-5-btn")));
		assertTrue(addProductAlfajor.getText().contains("Adicionar ao carrinho"));
		addProductAlfajor.click();
		
		WebElement openCategoriesAll = driver.findElement(By.id("open-categories-btn"));
		assertTrue(openCategoriesAll.getText().contains("Doces"));
		openCategoriesAll.click();
		
		WebElement selectCandiesAll = driver.findElement(By.id("category-all"));
		assertTrue(selectCandiesAll.getText().contains("Todos"));
		selectCandiesAll.click();
		
		WebElement cart = driver.findElement(By.id("cart-btn"));
		cart.click();
		for (int i = 1; i<4; i++) {
			WebElement increase = driver.findElement(By.id("add-product-4-qtd"));
			increase.click();
		}
		WebElement finish = driver.findElement(By.id("finish-checkout-button"));
		finish.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement finishRequest = driver.findElement(By.className("jyncPa"));
        assertEquals(finishRequest.getText(),("Pedido realizado com sucesso!"));
        
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        WebElement close = driver.findElement(By.className("ippulb"));
        close.click();
		
	}

}
