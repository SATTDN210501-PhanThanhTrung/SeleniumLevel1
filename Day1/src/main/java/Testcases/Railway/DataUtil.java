import Common.Untilities;
import org.json.simple.JSONArray;
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
            Object obj = parser.parse(new FileReader(Untilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data2.json"));
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
    @DataProvider
    public Object[] dataProvider2() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject ;

        Object obj=null;
        try {
            obj = parser.parse(new FileReader(Untilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json"));
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        jsonObject=(JSONObject) obj;

        assert jsonObject !=null;
        JSONArray formInfor=(JSONArray) jsonObject.get("TC14");

        String[] dataArray=new String[formInfor.size()];
        JSONObject formInforData;
        String departDate,departFrom,arriveAt,seatType,ticketAmount;

        for(int i=0;i<formInfor.size();i++){
            formInforData=(JSONObject) formInfor.get(i);
            departDate=(String) formInforData.get("DepartDate");
            departFrom=(String) formInforData.get("DepartFrom");
            arriveAt=(String) formInforData.get("ArriveAt");
            seatType=(String) formInforData.get("SeatType");
            ticketAmount=(String) formInforData.get("TicketAmount");

            dataArray[i]= departDate+","+departFrom+","+arriveAt+","+seatType+","+ticketAmount;

        }
        return dataArray;
    }
}
