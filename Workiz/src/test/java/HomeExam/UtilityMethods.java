package HomeExam;

import org.openqa.selenium.WebElement;



public class UtilityMethods {

    public void findClientName(WebElement element, String name) {
        element.sendKeys(name);

    }


}
