package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import dto.PasswordInfo;

import java.io.*;
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

    public List<PasswordInfo> fetchAllPassword() throws IOException {
        List<PasswordInfo> passwordInfoList = new ArrayList<>();
        if (Files.exists(Paths.get(FILE_PATH)) && Files.size(Paths.get(FILE_PATH)) > 0) {
            FileReader reader = new FileReader(FILE_PATH);
            Gson gson = new Gson();

            Type listType = new TypeToken<List<PasswordInfo>>() {}.getType();

            passwordInfoList = gson.fromJson(reader, listType);
            reader.close();
        } else {
            System.out.println("File does not exist or is empty.");
        }
        return passwordInfoList;
    }

    public List<PasswordInfo> getAllPassword(){
        List<PasswordInfo> passwordInfoList = new ArrayList<>();
        try {
            passwordInfoList = fetchAllPassword();
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
        return passwordInfoList;
    }

    public void storePasswordData (List<PasswordInfo> passwordInfoList){
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();
        for (PasswordInfo existingPasswordInfo : passwordInfoList) {
            JsonObject existingJsonObject = new JsonObject();
            existingJsonObject.addProperty("websiteName", existingPasswordInfo.getWebsiteName());
            existingJsonObject.add("passwordData", gson.toJsonTree(existingPasswordInfo.getPasswordData()));
            jsonArray.add(existingJsonObject);
        }
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            gson.toJson(jsonArray, writer);
        }catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public boolean savePasswordData(PasswordInfo passwordInfo){
        File directory = new File(DIRECTORY_PATH);
        JsonArray jsonArray = new JsonArray();
        Gson gson = new Gson();
        if (!directory.exists()) {
            directory.mkdir();
        }

        List<PasswordInfo> passwordInfoList = null;
        try {
            passwordInfoList = fetchAllPassword();
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
        assert passwordInfoList != null;
        passwordInfoList.add(passwordInfo);
        storePasswordData(passwordInfoList);
        return true;
    }
}
