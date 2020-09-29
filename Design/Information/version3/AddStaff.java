package version3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *  增加职员信息界面
 * @author 周明华
 *
 */
public class AddStaff extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label name = new Label("姓名:");
		name.setMinSize(50, 20);
		TextField addName = new TextField();
        addName.setPromptText("姓名");
        addName.setMaxSize(200, 50);      
        HBox box1 = new HBox(10, name, addName);
        box1.setAlignment(Pos.CENTER);
        
        Label address = new Label("地址:");  
        address.setMinSize(50, 20);
        TextField addAddress = new TextField();
        addAddress.setPromptText("地址");
        addAddress.setMaxSize(200, 50);
        HBox box2 = new HBox(10, address, addAddress);
        box2.setAlignment(Pos.CENTER);
        
        Label number = new Label("号码:"); 
        number.setMinSize(50, 20);
        TextField addPhoneNumber = new TextField();
        addPhoneNumber.setPromptText("电话号码");
        addPhoneNumber.setMaxSize(200, 50);
        HBox box3 = new HBox(10, number, addPhoneNumber);
        box3.setAlignment(Pos.CENTER);
        
        Label email = new Label("邮件:"); 
        email.setMinSize(50, 20);
        TextField addEmai = new TextField();
        addEmai.setPromptText("邮件");
        addEmai.setMaxSize(200, 50);
        HBox box4 = new HBox(10, email, addEmai);
        box4.setAlignment(Pos.CENTER);
        
        Label office = new Label("办公室:");
        office.setMinSize(50, 20);
        TextField addOfficeCol = new TextField();
        addOfficeCol.setPromptText("办公室");
        addOfficeCol.setMaxSize(200, 50);
        HBox box5 = new HBox(10, office, addOfficeCol);
        box5.setAlignment(Pos.CENTER);
        
        Label salary = new Label("工资:");
        salary.setMinSize(50, 20);
        TextField addSalaryCol = new TextField();
        addSalaryCol.setPromptText("工资");
        addSalaryCol.setMaxSize(200, 50);
        HBox box6 = new HBox(10, salary, addSalaryCol);
        box6.setAlignment(Pos.CENTER);
        
        Label time = new Label("时间:");
        time.setMinSize(50, 20);
        TextField addTime = new TextField();
        addTime.setPromptText("入职时间");
        addTime.setMaxSize(200, 50);
        HBox box7 = new HBox(10, time, addTime);
        box7.setAlignment(Pos.CENTER);
        
        Label title = new Label("称号:");
        title.setMinSize(50, 20);
        TextField addTitle = new TextField();
        addTitle.setPromptText("职务称号");
        addTitle.setMaxSize(200, 50);
        HBox box8 = new HBox(10, title, addTitle);
        box8.setAlignment(Pos.CENTER);
        
        Button saveButton = new Button("保存");
        saveButton.setMinSize(50, 20);
        saveButton.setOnAction(event -> {
        	ArrayList<String> str = new ArrayList<String>();
        	str.add(addName.getText());
        	str.add(addAddress.getText());
        	str.add(addPhoneNumber.getText());
        	str.add(addEmai.getText());
        	str.add(addOfficeCol.getText());
        	str.add(addSalaryCol.getText());
        	str.add(addTime.getText());
        	str.add(addTitle.getText());
        	
        	try {
				saveToFile(str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        	
        	StaffTable staffTable = new StaffTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1100);
    		newStage.setMinHeight(500);
    		
        	try {
        		staffTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        });
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	StaffTable staffTable = new StaffTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1100);
    		newStage.setMinHeight(500);
    		
        	try {
        		staffTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox box = new HBox(100);
        box.getChildren().addAll(backButton, saveButton);
        box.setAlignment(Pos.CENTER);
        
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(
        		box1, box2, box3, box4, box5, box6, box7, box8, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("增加职员信息");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	/**
	 * 写入文件
	 * @param staff
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<String> staff) throws FileNotFoundException {
		try(PrintWriter output = new PrintWriter(new FileOutputStream("staff.txt", true));){
			for (String str : staff) {
				output.print(str + "\t");
			}
			output.println();
		}		
	}
}
