package version3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import version2.Employee;
/**
 * 雇员信息管理界面
 * @author 周明华
 *
 */
public class EmployeeTable extends Application {

    private final TableView<Employee> table = new TableView<>();

	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		
		ArrayList<Employee> list = new ArrayList<>();
		try {
			list = readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ObservableList<Employee> data = FXCollections.observableArrayList(list);
		 
        Scene scene = new Scene(new Group());
        stage.setTitle("雇员信息管理");
        stage.setWidth(1000);
        stage.setHeight(500);

        table.setEditable(true);

        TableColumn<Employee, String> nameCol = new TableColumn<>("姓名");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//数据关联到表格
        
        TableColumn<Employee, String> adressCol = new TableColumn<>("地址");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));//数据关联到表格
        
        TableColumn<Employee, String> phoneNumberCol = new TableColumn<>("电话号码");
        phoneNumberCol.setMinWidth(200);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));//数据关联到表格
        
        TableColumn<Employee, String> emailCol = new TableColumn<>("电子邮件");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));//数据关联到表格
        
        TableColumn<Employee, String> officeCol = new TableColumn<>("办公室");
        officeCol.setMinWidth(100);
        officeCol.setCellValueFactory(new PropertyValueFactory<>("office"));//数据关联到表格
        
        TableColumn<Employee, String> salaryCol = new TableColumn<>("工资");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));//数据关联到表格
        
        TableColumn<Employee, String> time = new TableColumn<>("入职时间");
        time.setMinWidth(100);
        time.setCellValueFactory(new PropertyValueFactory<>("time"));//数据关联到表格
        
        table.setItems(data);//向表中添加数据
        table.getColumns().addAll(nameCol, adressCol, phoneNumberCol, emailCol, officeCol, salaryCol, time);
        
        Button addButton = new Button("增加");
        addButton.setMinSize(50, 20);
        addButton.setOnAction(event -> {
        	AddEmployee addEmployee = new AddEmployee();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(400);
    		
        	try {
        		addEmployee.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button deletButton = new Button("删除");
        deletButton.setMinSize(50, 20);
        deletButton.setOnAction(event -> {
        	DeleteEmployeeSearch deleteEmployeeSearch = new DeleteEmployeeSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		deleteEmployeeSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button changeButton = new Button("修改");
        changeButton.setMinSize(50, 20);
        changeButton.setOnAction(event -> {
        	ChangeEmployeeSearch changeEmployeeSearch = new ChangeEmployeeSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		changeEmployeeSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });	
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	
        	SearchEmployee searchEmployee = new SearchEmployee();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		searchEmployee.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	MainFrame mainPan = new MainFrame();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
        	newStage.setMinHeight(350);
    		newStage.setMinWidth(350);
    		
        	try {
				mainPan.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(addButton, deletButton, changeButton, searchButton, backButton);
        hBox.setAlignment(Pos.TOP_RIGHT);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 20));
        vbox.getChildren().addAll(hBox, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
	/**
	 * 读文件
	 * @return
	 * @throws FileNotFoundException
	 */
	public ArrayList<Employee> readFile() throws FileNotFoundException {
    	
		ArrayList<Employee> list = new ArrayList<>();
		Employee employee = new Employee();
    	
    	try(Scanner input = new Scanner(new File("employee.txt"));) {
    		int count = 0;
    		int index = 0;
    		while (input.hasNext()) {
				String string = input.next();
				switch (count) {
				case 0:
					if (index == 0) {//解决一个小BUG
						string = string.substring(1);
						index++;
					}
					employee.setName(string);
					break;
				case 1:
					employee.setAddress(string);
					break;
				case 2:
					employee.setPhoneNumber(string);
					break;
				case 3:
					employee.setEmail(string);
					break;
				case 4:
					employee.setOffice(string);
					break;					
				case 5:
					employee.setSalary(string);
					break;					
				case 6:
					employee.setTime(string);
					break;					
				default:
					break;
				}
				if ((++count) % 7 == 0) {
					list.add(employee);
					employee = new Employee();
				}
				count = count % 7;	
			}
    		
    	}
		 
		return list;
	}
}
