package pages.components;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


@Getter
public class DesktopComponents {

    private WebElement weName;
    private String name;
    private String newPrice;
    private String oldPrice;
    private String exTax;
    private WebElement addToCard;
    private WebElement addToWishList;
    private WebElement compareThisProduct;

    public DesktopComponents(WebElement container){
        this.weName = container.findElement(By.xpath(".//div[@class='description']//a"));
        this.name = weName.getText();
        this.newPrice = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-new']")).getText();
        try {
            this.oldPrice = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-old']")).getText();
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }
        this.exTax = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-tax']")).getText().substring(8);
        this.addToCard = container.findElement(By.xpath(".//div[@class='button-group']/button[@aria-label='Add to Cart']"));
        this.addToWishList = container.findElement(By.xpath(".//div[@class='button-group']/button[@aria-label='Add to Wish List']"));
        this.compareThisProduct = container.findElement(By.xpath(".//div[@class='button-group']/button[@aria-label='Compare this Product']"));

    }


}
