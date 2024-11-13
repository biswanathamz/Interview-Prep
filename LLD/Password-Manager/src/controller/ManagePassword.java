package controller;

import dto.Password;
import dto.PasswordInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ManagePassword {
    Scanner scannerObj = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ManagePassword(){
    }

    public boolean savePasswordData(Password password){
        System.out.println(password);
        return true;
    }

    public void takeInputForNewPassword(){
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
        boolean savePasswordDataFlag = savePasswordData(password);
    }
}
