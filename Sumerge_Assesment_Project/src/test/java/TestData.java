import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "excelData")
    public static Object[][] getData() {

        String path = "testdata/testdata.xlsx";
        String sheet = "data";

        return ExcelUtils.getExcelData(path, sheet);
    }
}

