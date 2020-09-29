package version3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version2.Employee;
/**
 * 查询雇员界面
 * @author 周明华
 *
 */
public class SearchEmployee extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text = new Text("请输入查询的姓名");
		
		TextField searchName = new TextField();
		searchName.setPromptText("姓名");
		searchName.setMaxSize(200, 50);
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	EmployeeTable employee = new EmployeeTable();
        	ArrayList<Employee> list = new ArrayList<>();
        	ArrayList<Employee> list2 = new ArrayList<>();
    		try {
    			list = employee.readFile();
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		
    		for (Employee employee1 : list) {
    			if ((employee1.getName()).equals(searchName.getText())) {
					list2.add(employee1);
				}
			}
    		
    		ShowSearchEmployeeTable showSearchEmployeeTable = new ShowSearchEmployeeTable();
    		primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		showSearchEmployeeTable.start(newStage, list2);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	EmployeeTable employeeTable = new EmployeeTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		employeeTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox box = new HBox(100);
        box.getChildren().addAll(backButton, searchButton);
        box.setAlignment(Pos.CENTER);
        
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(text,searchName, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("雇员信息查询");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
}
