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
import version2.Faculty;
/**
 * 查询教员界面
 * @author 周明华
 *
 */
public class SearchFaculty extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text = new Text("请输入查询的姓名");
		
		TextField searchName = new TextField();
		searchName.setPromptText("姓名");
		searchName.setMaxSize(200, 50);
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	FacultyTable facultyTable = new FacultyTable();
        	ArrayList<Faculty> list = new ArrayList<>();
        	ArrayList<Faculty> list2 = new ArrayList<>();
    		try {
    			list = facultyTable.readFile();
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		
    		for (Faculty faculty : list) {
    			if ((faculty.getName()).equals(searchName.getText())) {
					list2.add(faculty);
				}
			}
    		
    		ShowSearchFacultyTable showSearchFacultyTable = new ShowSearchFacultyTable();
    		primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1200);
    		newStage.setMinHeight(500);
    		
        	try {
        		showSearchFacultyTable.start(newStage, list2);
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
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		facultyTable.start(newStage);
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
        primaryStage.setTitle("教员信息查询");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
}
