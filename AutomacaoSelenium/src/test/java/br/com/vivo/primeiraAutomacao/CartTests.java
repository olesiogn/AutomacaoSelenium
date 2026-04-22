package br.com.vivo.primeiraAutomacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CartTests {

    @Test
    public void testCreateCart() throws InterruptedException {
        // Gerencia chromedriver
        WebDriverManager.chromedriver().setup();

        // Inicia o driver
        WebDriver driver = new ChromeDriver();

        // Maximiza o navegador
        driver.manage().window().maximize();

        // Adiciona uma espera implicita. Espera ate 20 segundos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Navega para um site
        driver.get("https://store.vivo.com.br/");

        // Clicar no botão 'Continuar e fechar'
        driver.findElement(By.xpath("//button[@id='consent']")).click();

        // Clicar no menu 'Celulares'
        driver.findElement(By.xpath("//a[@title='Celulares']")).click();

        // Clicar no primeiro aparelho do menu 'Celulares'
        driver.findElement(By.xpath("(//a[@class='product-card product-card--grid'])[1]")).click();

        // Encerra o processo do chromeDriver no windows
        //driver.quit();
    }

}
