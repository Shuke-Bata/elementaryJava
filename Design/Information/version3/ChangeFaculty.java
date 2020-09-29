package version3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
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
 * 修改教员信息界面
 * @author 周明华
 *
 */
public class ChangeFaculty extends Application {
	
	public void start(Stage primaryStage, ArrayList<Faculty> list, int index) throws Exception {
		
		TextField addName = new TextField();
        addName.setText(list.get(index).getName());
        addName.setMaxSize(200, 50);
        
        TextField addAddress = new TextField();
        addAddress.setText(list.get(index).getAddress());
        addAddress.setMaxSize(200, 50);
        
        TextField addPhoneNumber = new TextField();
        addPhoneNumber.setText(list.get(index).getPhoneNumber());
        addPhoneNumber.setMaxSize(200, 50);
        
        TextField addEmai = new TextField();
        addEmai.setText(list.get(index).getEmail());
        addEmai.setMaxSize(200, 50);
        
        TextField addOfficeCol = new TextField();
        addOfficeCol.setText(list.get(index).getOffice());
        addOfficeCol.setMaxSize(200, 50);
        
        TextField addSalaryCol = new TextField();
        addSalaryCol.setText(list.get(index).getSalary());
        addSalaryCol.setMaxSize(200, 50);
        
        TextField addWorkHours = new TextField();
        addWorkHours.setText(list.get(index).getOfficeHours());
        addWorkHours.setMaxSize(200, 50);
        
        TextField addTime = new TextField();
        addTime.setText(list.get(index).getTime());
        addTime.setMaxSize(200, 50);
        
        TextField addRank = new TextField();
        addRank.setText(list.get(index).getRank());
        addRank.setMaxSize(200, 50);
        
        Button saveButton = new Button("修改");
        saveButton.setMinSize(50, 20);
        saveButton.setOnAction(event -> {
        	Faculty faculty = new Faculty();
        	faculty.setName(addName.getText());
        	faculty.setAddress(addAddress.getText());
        	faculty.setPhoneNumber(addPhoneNumber.getText());
        	faculty.setEmail(addEmai.getText());
        	faculty.setOffice(addOfficeCol.getText());
        	faculty.setSalary(addSalaryCol.getText());
        	faculty.setTime(addTime.getText());
        	faculty.setOfficeHours(addWorkHours.getText());
        	faculty.setRank(addRank.getText());
        	list.set(index, faculty);
        	
        	try {
				saveToFile(list,list.size());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        	
        	FacultyTable facultyTable = new FacultyTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1280);
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
        		addName, addAddress, addPhoneNumber, addEmai, addOfficeCol, addSalaryCol,
        		addTime, addWorkHours, addRank, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("修改教员信息");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	/**
	 * 写入文件
	 * @param facultys
	 * @param size
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<Faculty> facultys,int size) throws FileNotFoundException {
		String[][] str = new String[size][9];
		int i = 0;
		for (Faculty faculty : facultys) {
			if (i==0) {
				str[i][0] = "," + faculty.getName();
				str[i][1] = faculty.getAddress();
				str[i][2] = faculty.getPhoneNumber();
				str[i][3] = faculty.getEmail();
				str[i][4] = faculty.getOffice();	
				str[i][5] = faculty.getSalary();	
				str[i][6] = faculty.getTime();	
				str[i][7] = faculty.getOfficeHours();	
				str[i][8] = faculty.getRank();	
			}
			else {
				str[i][0] = faculty.getName();
				str[i][1] = faculty.getAddress();
				str[i][2] = faculty.getPhoneNumber();
				str[i][3] = faculty.getEmail();
				str[i][4] = faculty.getOffice();
				str[i][5] = faculty.getSalary();	
				str[i][6] = faculty.getTime();
				str[i][7] = faculty.getOfficeHours();	
				str[i][8] = faculty.getRank();
			}
			i++;
		}
		try(PrintWriter output = new PrintWriter(new FileOutputStream("faculty.txt"));){
			for (int j = 0; j < str.length; j++) {
				for (int k = 0; k < str[j].length; k++) {
					output.print(str[j][k] + "\t");
				}
				output.println();
			}
		}		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
/**
 * 修改教员信息查询界面
 * @author 周明华
 *
 */
class ChangeFacultySearch extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	Text text = new Text("请输入要更改的姓名");
	
	TextField searchName = new TextField();
	searchName.setPromptText("姓名");
	searchName.setMaxSize(200, 50);
    
    Button searchButton = new Button("查询");
    searchButton.setMinSize(50, 20);
    searchButton.setOnAction(event -> {
    	FacultyTable facultyTable = new FacultyTable();
    	ArrayList<Faculty> list = new ArrayList<>();
    	int index = -1;
		try {
			list = facultyTable.readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			String name =  list.get(i).getName();
			String search = searchName.getText();			
			if ((name).equals(search)) {
				index = i;
				break;
			}
		}
		
    	primaryStage.hide();//关闭
    	Stage newStage = new Stage();
		newStage.setMinWidth(400);
		newStage.setMinHeight(300);
		if (index >= 0) {
			try {
				ChangeFaculty changeFaculty = new ChangeFaculty();
				changeFaculty.start(newStage, list, index);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			SearchWrongFrame searchWrongFrame = new SearchWrongFrame();
			try {
				searchWrongFrame.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Timer myTimer = new Timer();
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					//在其他线程更新JavaFX的线程上的信息的时候,就可能报这种错误
					//解决办法
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	newStage.hide();//关闭
					    	Stage stage = new Stage();
							stage.setMinWidth(1280);
							stage.setMinHeight(500);			
					    	try {
					    		facultyTable.start(stage);
							} catch (Exception e) {
								e.printStackTrace();
							}
					    }
					});
					myTimer.cancel();		
				}
			};
			myTimer.schedule(tt, 1000);//1秒后执行
		}
    	
	    });
	    
	    Button backButton = new Button("返回");
	    backButton.setMinSize(50, 20);
	    backButton.setOnAction(event -> {
	    	FacultyTable facultyTable = new FacultyTable();
	    	
	    	primaryStage.hide();//关闭
	    	Stage newStage = new Stage();
			newStage.setMinWidth(1280);
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