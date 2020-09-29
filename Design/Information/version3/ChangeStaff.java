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
import version2.Staff;
/**
 * 修改职员信息界面
 * @author 周明华
 *
 */
public class ChangeStaff extends Application {
	
	public void start(Stage primaryStage, ArrayList<Staff> list, int index) throws Exception {
		
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
        
        TextField addTime = new TextField();
        addTime.setText(list.get(index).getTime());
        addTime.setMaxSize(200, 50);
        
        TextField addTitle = new TextField();
        addTitle.setText(list.get(index).getJobTitle());
        addTitle.setMaxSize(200, 50);
        
        Button saveButton = new Button("修改");
        saveButton.setMinSize(50, 20);
        saveButton.setOnAction(event -> {
        	Staff staff = new Staff();
        	staff.setName(addName.getText());
        	staff.setAddress(addAddress.getText());
        	staff.setPhoneNumber(addPhoneNumber.getText());
        	staff.setEmail(addEmai.getText());
        	staff.setOffice(addOfficeCol.getText());
        	staff.setSalary(addSalaryCol.getText());
        	staff.setTime(addTime.getText());
        	staff.setJobTitle(addTitle.getText());
        	list.set(index, staff);
        	
        	try {
				saveToFile(list,list.size());
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
        		addName, addAddress, addPhoneNumber, addEmai, addOfficeCol, addSalaryCol, addTime, addTitle, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("修改职员信息");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	/**
	 * 写入文件
	 * @param staffs
	 * @param size
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<Staff> staffs,int size) throws FileNotFoundException {
		String[][] str = new String[size][8];
		int i = 0;
		for (Staff staff : staffs) {
			if (i==0) {
				str[i][0] = "," + staff.getName();
				str[i][1] = staff.getAddress();
				str[i][2] = staff.getPhoneNumber();
				str[i][3] = staff.getEmail();
				str[i][4] = staff.getOffice();	
				str[i][5] = staff.getSalary();	
				str[i][6] = staff.getTime();	
				str[i][7] = staff.getJobTitle();	
			}
			else {
				str[i][0] = staff.getName();
				str[i][1] = staff.getAddress();
				str[i][2] = staff.getPhoneNumber();
				str[i][3] = staff.getEmail();
				str[i][4] = staff.getOffice();	
				str[i][5] = staff.getSalary();	
				str[i][6] = staff.getTime();	
				str[i][7] = staff.getJobTitle();
			}
			i++;
		}
		try(PrintWriter output = new PrintWriter(new FileOutputStream("staff.txt"));){
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
 * 修改职员信息查询界面
 * @author 周明华
 *
 */
class ChangeStaffSearch extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	Text text = new Text("请输入要更改的姓名");
	
	TextField searchName = new TextField();
	searchName.setPromptText("姓名");
	searchName.setMaxSize(200, 50);
    
    Button searchButton = new Button("查询");
    searchButton.setMinSize(50, 20);
    searchButton.setOnAction(event -> {
    	StaffTable staffTable = new StaffTable();
    	ArrayList<Staff> list = new ArrayList<>();
    	int index = -1;
		try {
			list = staffTable.readFile();
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
		newStage.setMinHeight(400);
		if (index >= 0) {
			try {
				ChangeStaff changeStaff = new ChangeStaff();
				changeStaff.start(newStage, list, index);
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
							stage.setMinWidth(1180);
							stage.setMinHeight(500);			
					    	try {
					    		staffTable.start(stage);
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
	    	EmployeeTable employeeTable = new EmployeeTable();
	    	
	    	primaryStage.hide();//关闭
	    	Stage newStage = new Stage();
			newStage.setMinWidth(1080);
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
	    primaryStage.setTitle("职员信息查询");
	    primaryStage.show();
	    primaryStage.setResizable(false);
	}
}