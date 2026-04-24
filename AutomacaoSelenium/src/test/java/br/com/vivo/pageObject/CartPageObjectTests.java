package br.com.vivo.pageObject;

import br.com.vivo.pageObject.pages.PageCarrinho;
import br.com.vivo.pageObject.pages.PageCelulares;
import br.com.vivo.pageObject.pages.PageHome;
import br.com.vivo.pageObject.pages.PageProduto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageObjectTests {
    private WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void CT1testCreateCart(){
        PageHome paginaHome = new PageHome(driver);
        PageCelulares paginaCelulares = new PageCelulares(driver);
        PageProduto paginaProduto = new PageProduto(driver);
        PageCarrinho paginaCarrinho = new PageCarrinho(driver);

        paginaHome.acessarOSite();
        paginaHome.aceitarTermosDeConsentimento();
        paginaHome.clicarNoMenuCelulares();
        paginaCelulares.escolherOSegundoAparelho();
        String precoProduto = paginaProduto.retornarPrecoDoProduto();
        paginaProduto.clicarEmColocarNoCarrinho();
        boolean estaNoCarrinho = paginaCarrinho.verificaProdutoNoCarrinho();

        assertTrue("O produto deve estar visível no carrinho", estaNoCarrinho);

        String valorTotal = paginaCarrinho.capturarValorTotalDoCarrinho();

        assertEquals("O valor total do carrinho deve ser igual ao preço do produto", precoProduto, valorTotal);
    }

    @Test
    public void CT2cadastroDeUmCliente(){
        PageHome paginaHome = new PageHome(driver);
        paginaHome.acessarOSite();
        paginaHome.aceitarTermosDeConsentimento();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
