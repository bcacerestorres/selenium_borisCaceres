package Practico14;
import org.testng.annotations.DataProvider;

public class DataProviderPeople {
    @DataProvider(name = "people")
    public Object[][]PeopleDataProvider(){
        return new Object[][]{{"Jose","Jara",20},{"Luis","Lara",25}};
    }
}
