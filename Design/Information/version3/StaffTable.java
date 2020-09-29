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
import version2.Staff;
/**
 * 职员信息管理界面
 * @author 周明华
 *
 */
public class StaffTable extends Application {

    private final TableView<Staff> table = new TableView<>();
    
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		
		ArrayList<Staff> list = new ArrayList<>();
		try {
			list = readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ObservableList<Staff> data = FXCollections.observableArrayList(list);
		
        Scene scene = new Scene(new Group());
        stage.setTitle("职员信息管理");
        stage.setWidth(1100);
        stage.setHeight(500);

        table.setEditable(true);

        TableColumn<Staff, String> nameCol = new TableColumn<>("姓名");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//数据关联到表格
        
        TableColumn<Staff, String> adressCol = new TableColumn<>("地址");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));//数据关联到表格
        
        TableColumn<Staff, String> phoneNumberCol = new TableColumn<>("电话号码");
        phoneNumberCol.setMinWidth(200);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));//数据关联到表格
        
        TableColumn<Staff, String> emailCol = new TableColumn<>("电子邮件");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));//数据关联到表格
        
        TableColumn<Staff, String> officeCol = new TableColumn<>("办公室");
        officeCol.setMinWidth(100);
        officeCol.setCellValueFactory(new PropertyValueFactory<>("office"));//数据关联到表格
        
        TableColumn<Staff, String> salaryCol = new TableColumn<>("工资");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));//数据关联到表格
        
        TableColumn<Staff, String> time = new TableColumn<>("入职时间");
        time.setMinWidth(100);
        time.setCellValueFactory(new PropertyValueFactory<>("time"));//数据关联到表格
        
        TableColumn<Staff, String> jobTitle = new TableColumn<>("职务称号");
        jobTitle.setMinWidth(100);
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));//数据关联到表格
        
        table.setItems(data);//向表中添加数据
        table.getColumns().addAll(nameCol, adressCol, phoneNumberCol, emailCol, officeCol, salaryCol, time, jobTitle);
        
        Button addButton = new Button("增加");
        addButton.setMinSize(50, 20);
        addButton.setOnAction(event -> {
        	AddStaff addStaff = new AddStaff();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(450);
    		
        	try {
        		addStaff.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button deletButton = new Button("删除");
        deletButton.setMinSize(50, 20);
        deletButton.setOnAction(event -> {
        	DeleteStaffSearch deleteStaffSearch = new DeleteStaffSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		deleteStaffSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button changeButton = new Button("修改");
        changeButton.setMinSize(50, 20);
        changeButton.setOnAction(event -> {
        	ChangeStaffSearch changeStaffSearch = new ChangeStaffSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		changeStaffSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });	
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	
        	SearchStaff searchStaff = new SearchStaff();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		searchStaff.start(newStage);
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
	 * 读取文件
	 * @return ArrayList
	 * @throws FileNotFoundException
	 */
	public ArrayList<Staff> readFile() throws FileNotFoundException {
    	
		ArrayList<Staff> list = new ArrayList<>();
		Staff staff = new Staff();
    	
    	try(Scanner input = new Scanner(new File("staff.txt"));) {
    		int count = 0;
//    		int index = 0;
    		while (input.hasNext()) {
				String string = input.next();
				switch (count) {
				case 0:
		/*			if (index == 0) {
						string = string.substring(1);
						index++;
					}*/
					staff.setName(string);
					break;
				case 1:
					staff.setAddress(string);
					break;
				case 2:
					staff.setPhoneNumber(string);
					break;
				case 3:
					staff.setEmail(string);
					break;
				case 4:
					staff.setOffice(string);
					break;					
				case 5:
					staff.setSalary(string);
					break;					
				case 6:
					staff.setTime(string);
					break;					
				case 7:
					staff.setJobTitle(string);
					break;					
				default:
					break;
				}
				if ((++count) % 8 == 0) {
					list.add(staff);
					staff = new Staff();
				}
				count = count % 8;	
			}
    		
    	}
		 
		return list;
	}
}
