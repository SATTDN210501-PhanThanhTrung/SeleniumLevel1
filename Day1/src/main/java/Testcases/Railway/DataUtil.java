import Common.Untilities;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtil extends TestBase {

    @DataProvider
    public Object[] dataProvider1() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            Object obj = parser.parse(new FileReader(Untilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        Object[] data = new Object[1];
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set<String> jsonObjKeys = jsonObject.keySet();
            for (String jsonObjKey : jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        } else {
            System.out.println("Error data");
        }
        data[0] = hashMap;
        return data;
    }
}
