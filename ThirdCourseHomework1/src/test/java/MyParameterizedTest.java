import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MyParameterizedTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up the test environment.");
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
                { 2, 2, 4 },
                { 0, 5, 5 },
                { -3, 3, 0 },
                { 10, 5, 15 }
        };
    }

    @Test(dataProvider = "testData")
    public void myParameterizedTest(int a, int b, int expectedResult) {
        int actualResult = a + b;
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("Cleaning up the test environment.");
    }
}
