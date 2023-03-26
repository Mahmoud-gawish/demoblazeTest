package end_to_end;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

import static pages.HomePage.getHomePage;

public class ListItemTests extends TestBase {

    HomePage homePage = getHomePage();


    @Test
    public void testIsAllPhonesItemsPresent(){
        boolean flag =  homePage.selectPhones().isAllItemPresent(8);
        System.out.println(flag);
    }

    @Test
    public void testIsAllLaptopsItemsPresent(){
        boolean flag =  homePage.selectLaptops().isAllItemPresent(7);
        System.out.println(flag);
    }

    @Test
    public void testIsAllMonitorsItemsPresent(){
        boolean flag =  homePage.selectMonitors().isAllItemPresent(3);
        System.out.println(flag);
    }
}
