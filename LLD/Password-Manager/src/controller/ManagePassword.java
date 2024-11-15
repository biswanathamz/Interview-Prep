package controller;

import dto.Password;
import dto.PasswordInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ManagePassword {
    Scanner scannerObj = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    FileOperation fileOperation = new FileOperation();
    public ManagePassword(){

    }

    public void allWebsiteList(){
        try{
            List<String> websiteNames = new ArrayList<>();
            List<PasswordInfo> passwordInfoList =  fileOperation.getAllPassword();
            if(passwordInfoList==null){
                System.out.println("There are No Password available!");
                return;
            }
            for (PasswordInfo passwordInfo : passwordInfoList){
                websiteNames.add(passwordInfo.getWebsiteName());
            }
            System.out.println("Please find below all the websites : ");
            for (String websiteName : websiteNames){
                System.out.println(websiteName);
            }
            System.out.println("Do you want to see password of any of the website? 1 for Yes else back to main menu.");
            int allWebsiteListOption = 0;
            try{
                allWebsiteListOption = Integer.parseInt(scannerObj.nextLine());
            }catch (NumberFormatException e){
                return;
            }
            if(allWebsiteListOption==1){
                viewAPassword();
            }else {
                return;
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void viewAPassword(){
        try{
            PasswordInfo viewPasswordInfo = null;
            List<PasswordInfo> passwordInfoList =  fileOperation.getAllPassword();
            if(passwordInfoList==null){
                System.out.println("There are No Password available!");
                return;
            }
            System.out.println("Please enter the Website name : ");
            String varWebsiteName = this.scannerObj.nextLine();
            for (PasswordInfo passwordInfo : passwordInfoList){
                if(Objects.equals(passwordInfo.getWebsiteName(), varWebsiteName)){
                    viewPasswordInfo = passwordInfo;
                }
            }
            if(viewPasswordInfo!=null){
                System.out.println("Password for "+varWebsiteName+" is : "+viewPasswordInfo.getPasswordData().getPassword());
            }else{
                System.out.println("No password data found for the website: " + varWebsiteName);
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void takeInputForNewPassword(){
        try{
            System.out.println("Please Enter the Website name : ");
            String varWebsiteName = this.scannerObj.nextLine();
            System.out.println("Please Enter the username for  "+varWebsiteName+" : ");
            String varUserName = this.scannerObj.nextLine();
            System.out.println("Please Enter the Password for  "+varWebsiteName+" : ");
            String varPassword = this.scannerObj.nextLine();

            Password password = new Password();
            password.setUserName(varUserName);
            password.setPassword(varPassword);
            password.setCreatedAt(LocalDateTime.now().format(this.formatter));
            password.setModifiedAt(LocalDateTime.now().format(this.formatter));

            PasswordInfo passwordInfo = new PasswordInfo();
            passwordInfo.setWebsiteName(varWebsiteName);
            passwordInfo.setPasswordData(password);

            boolean savePasswordDataFlag = fileOperation.savePasswordData(passwordInfo);

            if (savePasswordDataFlag) {
                System.out.println("Password data saved successfully.");
            } else {
                System.out.println("Failed to save password data.");
            }

        }catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
        } catch (NullPointerException e) {
            System.out.println("Null value encountered, please ensure all inputs are valid.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void updatePassword(){
        try{
            boolean updateFoundFlag = false;
            List<PasswordInfo> passwordInfoList =  fileOperation.getAllPassword();
            if(passwordInfoList==null){
                System.out.println("There are No Password available to update!");
                return;
            }
            System.out.println("Please enter the website name to update it's password");
            String varWebsiteName = scannerObj.nextLine();
            for (PasswordInfo passwordInfo : passwordInfoList){
                if(Objects.equals(passwordInfo.getWebsiteName(), varWebsiteName)){
                    System.out.println("Please enter the new password : ");
                    String varPassword = scannerObj.nextLine();
                    passwordInfo.getPasswordData().setPassword(varPassword);
                    passwordInfo.getPasswordData().setModifiedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    updateFoundFlag = true;
                }
            }
            if(updateFoundFlag){
                if(fileOperation.storePasswordData(passwordInfoList)){
                    System.out.println("Password updated successfully.");
                }else{
                    System.out.println("Unable to update the password.");
                }
            }else{
                System.out.println("No matching website name found.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
        } catch (NullPointerException e) {
            System.out.println("Null value encountered, please ensure all inputs are valid.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void deletePassword(){
        List<PasswordInfo> passwordInfoList =  fileOperation.getAllPassword();
        if(passwordInfoList==null){
            System.out.println("There are No Password available to delete!");
            return;
        }
        try{
            Iterator<PasswordInfo> passwordInfoIterator = passwordInfoList.iterator();
            System.out.println("Please enter the website name to delete");
            String varWebsiteName = scannerObj.nextLine();
            boolean deleteFlag = false;
            while (passwordInfoIterator.hasNext()){
                PasswordInfo passwordInfo = passwordInfoIterator.next();
                if(Objects.equals(passwordInfo.getWebsiteName(), varWebsiteName)){
                    passwordInfoIterator.remove();
                    deleteFlag = true;
                }
            }
            if(deleteFlag){
                if(fileOperation.storePasswordData(passwordInfoList)){
                    System.out.println("Password deleted for : "+varWebsiteName);
                }else{
                    System.out.println("System Error unable to delete the website's password.");
                }
            }else{
                System.out.println("No website found with the given name to delete.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
        } catch (NullPointerException e) {
            System.out.println("Null value encountered, please ensure all inputs are valid.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
