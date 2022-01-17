import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class jsonParser {

    public static void main(String[] args) {
        String json = readString("data2.json");
        List<Employee> list = jsonToList(json);
        System.out.println(list);
    }

    public static String readString(String string) {
        String file = null;
        try (BufferedReader br = new BufferedReader(new FileReader(string))) {
            String jsFile;
            while ((jsFile = br.readLine()) != null) {
                file = jsFile;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    public static List<Employee> jsonToList(String string) {
        List<Employee> employeeList = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        employeeList = gson.fromJson(string, listType);
        return employeeList;
    }
}

