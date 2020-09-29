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
import version2.Employee;
/**
 * 删除雇员信息界面
 * @author 周明华
 *
 */
public class DeleteEmployee extends Application {
	
	public void start(Stage primaryStage, ArrayList<Employee> list, int index) throws Exception {
		
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
        
        Button saveButton = new Button("删除");
        saveButton.setMinSize(50, 20);
        saveButton.setOnAction(event -> {
        	list.remove(index);
        	
        	try {
				saveToFile(list,list.size());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        	
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
        box.getChildren().addAll(backButton, saveButton);
        box.setAlignment(Pos.CENTER);
        
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(
        		addName, addAddress, addPhoneNumber, addEmai, addOfficeCol, addSalaryCol, addTime, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("删除雇员信息");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	/**
	 * 写入文件
	 * @param employees
	 * @param size
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<Employee> employees,int size) throws FileNotFoundException {
		String[][] str = new String[size][7];
		int i = 0;
		for (Employee employee : employees) {
			if (i==0) {
				str[i][0] = "," + employee.getName();
				str[i][1] = employee.getAddress();
				str[i][2] = employee.getPhoneNumber();
				str[i][3] = employee.getEmail();
				str[i][4] = employee.getOffice();	
				str[i][5] = employee.getSalary();	
				str[i][6] = employee.getTime();	
			}
			else {
				str[i][0] = employee.getName();
				str[i][1] = employee.getAddress();
				str[i][2] = employee.getPhoneNumber();
				str[i][3] = employee.getEmail();
				str[i][4] = employee.getOffice();
				str[i][5] = employee.getSalary();	
				str[i][6] = employee.getTime();
			}
			i++;
		}
		try(PrintWriter output = new PrintWriter(new FileOutputStream("employee.txt"));){
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
 * 删除雇员信息查询界面
 * @author 周明华
 *
 */
class DeleteEmployeeSearch extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	Text text = new Text("请输入要删除的姓名");
	
	TextField searchName = new TextField();
	searchName.setPromptText("姓名");
	searchName.setMaxSize(200, 50);
    
    Button searchButton = new Button("查询");
    searchButton.setMinSize(50, 20);
    searchButton.setOnAction(event -> {
    	EmployeeTable employeeTable = new EmployeeTable();
    	ArrayList<Employee> list = new ArrayList<>();
    	int index = -1;
		try {
			list = employeeTable.readFile();
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
				DeleteEmployee deleteEmployee = new DeleteEmployee();
				deleteEmployee.start(newStage, list, index);
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
							stage.setMinWidth(1080);
							stage.setMinHeight(500);			
					    	try {
					    		employeeTable.start(stage);
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
	    primaryStage.setTitle("雇员信息查询");
	    primaryStage.show();
	    primaryStage.setResizable(false);
	}
}