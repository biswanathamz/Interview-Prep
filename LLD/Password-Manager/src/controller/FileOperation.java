package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import dto.PasswordInfo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

    private static final String DIRECTORY_PATH = "data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/passwordData.json";

    public FileOperation(){

    }

    public List<PasswordInfo> getAllPassword(){
        List<PasswordInfo> passwordInfoList = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(FILE_PATH)) && Files.size(Paths.get(FILE_PATH)) > 0) {
                FileReader reader = new FileReader(FILE_PATH);
                Gson gson = new Gson();

                Type listType = new TypeToken<List<PasswordInfo>>() {}.getType();

                passwordInfoList = gson.fromJson(reader, listType);
                reader.close();
            } else {
                System.out.println("File does not exist or is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
        return passwordInfoList;
    }

    public boolean savePasswordData(PasswordInfo passwordInfo){
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonArray();

            if (Files.exists(Paths.get(FILE_PATH))) {
                System.out.println("Paths.get(FILE_PATH)");
                System.out.println(Paths.get(FILE_PATH));
                String jsonString = "";
                try{
                    jsonString = Files.readString(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
                }catch (IOException e) {
                    e.printStackTrace(); // Print stack trace to debug
                }
//                String jsonString = Files.readString(Paths.get(FILE_PATH));
                System.out.println("jsonString");
                System.out.println(jsonString);
                if (!jsonString.isEmpty()) {
                    jsonArray = gson.fromJson(jsonString, JsonArray.class);
                    System.out.println("jsonArray");
                    System.out.println(jsonArray);
                }
            }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("websiteName", passwordInfo.getWebsiteName());
            jsonObject.add("passwordData", gson.toJsonTree(passwordInfo.getPasswordData()));
            jsonArray.add(jsonObject);
            System.out.println(jsonArray);
            gson.toJson(jsonArray, writer);
            System.out.println("Data saved to file successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
            return false;
        }
    }

}
