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
 *  增加教员信息界面
 * @author 周明华
 *
 */
public class AddFaculty extends Application{
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
        
        Label time = new Label("入职:");
        time.setMinSize(50, 20);
        TextField addTime = new TextField();
        addTime.setPromptText("入职时间");
        addTime.setMaxSize(200, 50);
        HBox box7 = new HBox(10, time, addTime);
        box7.setAlignment(Pos.CENTER);
        
        Label work = new Label("工作:");
        work.setMinSize(50, 20);
        TextField addWorkHours = new TextField();
        addWorkHours.setPromptText("工作时间");
        addWorkHours.setMaxSize(200, 50);
        HBox box8 = new HBox(10, work, addWorkHours);
        box8.setAlignment(Pos.CENTER);
        
        Label rank = new Label("级别:");
        rank.setMinSize(50, 20);
        TextField addRank = new TextField();
        addRank.setPromptText("级别");
        addRank.setMaxSize(200, 50);
        HBox box9 = new HBox(10, rank, addRank);
        box9.setAlignment(Pos.CENTER);
         
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
        	str.add(addWorkHours.getText());
        	str.add(addRank.getText());
        	
        	try {
				saveToFile(str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        	
        	FacultyTable facultyTable = new FacultyTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1200);
    		newStage.setMinHeight(500);
    		
        	try {
        		facultyTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	FacultyTable facultyTable = new FacultyTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1200);
    		newStage.setMinHeight(500);
    		
        	try {
        		facultyTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox box = new HBox(100);
        box.getChildren().addAll(backButton, saveButton);
        box.setAlignment(Pos.CENTER);
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(
        		box1, box2, box3, box4, box5, box6, box7, box8, box9, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("增加教员信息");
        primaryStage.show();
        primaryStage.setResizable(false);
   }
	/**
	 * 写入文件
	 * @param faculty
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<String> faculty) throws FileNotFoundException {
		try(PrintWriter output = new PrintWriter(new FileOutputStream("faculty.txt", true));){
			for (String str : faculty) {
				output.print(str + "\t");
			}
			output.println();
		}		
	}
}
