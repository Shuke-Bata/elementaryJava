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

import version2.Faculty;
/**
 * 教员信息管理界面
 * @author 周明华
 *
 */
public class FacultyTable extends Application {

    private final TableView<Faculty> table = new TableView<>();
    
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		
		ArrayList<Faculty> list = new ArrayList<>();
		try {
			list = readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ObservableList<Faculty> data = FXCollections.observableArrayList(list);
		
        Scene scene = new Scene(new Group());
        stage.setTitle("教员信息管理");
        stage.setWidth(1200);
        stage.setHeight(500);

        table.setEditable(true);

        TableColumn<Faculty, String> nameCol = new TableColumn<>("姓名");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//数据关联到表格
        
        TableColumn<Faculty, String> adressCol = new TableColumn<>("地址");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));//数据关联到表格
        
        TableColumn<Faculty, String> phoneNumberCol = new TableColumn<>("电话号码");
        phoneNumberCol.setMinWidth(200);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));//数据关联到表格
        
        TableColumn<Faculty, String> emailCol = new TableColumn<>("电子邮件");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));//数据关联到表格
        
        TableColumn<Faculty, String> officeCol = new TableColumn<>("办公室");
        officeCol.setMinWidth(100);
        officeCol.setCellValueFactory(new PropertyValueFactory<>("office"));//数据关联到表格
        
        TableColumn<Faculty, String> salaryCol = new TableColumn<>("工资");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));//数据关联到表格
        
        TableColumn<Faculty, String> time = new TableColumn<>("入职时间");
        time.setMinWidth(100);
        time.setCellValueFactory(new PropertyValueFactory<>("time"));//数据关联到表格
        
        TableColumn<Faculty, String> officeHours = new TableColumn<>("工作时间");
        officeHours.setMinWidth(100);
        officeHours.setCellValueFactory(new PropertyValueFactory<>("officeHours"));//数据关联到表格
        
        TableColumn<Faculty, String> rank = new TableColumn<>("级别");
        rank.setMinWidth(100);
        rank.setCellValueFactory(new PropertyValueFactory<>("rank"));//数据关联到表格
        
        table.setItems(data);//向表中添加数据
        table.getColumns().addAll(
        		 nameCol, adressCol, phoneNumberCol, emailCol, officeCol, salaryCol, time, officeHours, rank);
        
        Button addButton = new Button("增加");
        addButton.setMinSize(50, 20);
        addButton.setOnAction(event -> {
        	AddFaculty addFaculty = new AddFaculty();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(500);
    		
        	try {
        		addFaculty.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button deletButton = new Button("删除");
        deletButton.setMinSize(50, 20);
        deletButton.setOnAction(event -> {
        	DeleteFacultySearch deleteFacultySearch = new DeleteFacultySearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(400);
    		
        	try {
        		deleteFacultySearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button changeButton = new Button("修改");
        changeButton.setMinSize(50, 20);
        changeButton.setOnAction(event -> {
        	ChangeFacultySearch changeFacultySearch = new ChangeFacultySearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(400);
    		
        	try {
        		changeFacultySearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });	
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	
        	SearchFaculty searchFaculty = new SearchFaculty();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		searchFaculty.start(newStage);
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
	public ArrayList<Faculty> readFile() throws FileNotFoundException {
    	
		ArrayList<Faculty> list = new ArrayList<>();
		Faculty faculty = new Faculty();
    	
    	try(Scanner input = new Scanner(new File("faculty.txt"));) {
    		int count = 0;
//    		int index = 0;
    		while (input.hasNext()) {
				String string = input.next();
				switch (count) {
				case 0:
					/*if (index == 0) {
						string = string.substring(1);
						index++;
					}*/
					faculty.setName(string);
					break;
				case 1:
					faculty.setAddress(string);
					break;
				case 2:
					faculty.setPhoneNumber(string);
					break;
				case 3:
					faculty.setEmail(string);
					break;
				case 4:
					faculty.setOffice(string);
					break;					
				case 5:
					faculty.setSalary(string);
					break;					
				case 6:
					faculty.setTime(string);
					break;					
				case 7:
					faculty.setOfficeHours(string);
					break;					
				case 8:
					faculty.setRank(string);
					break;					
				default:
					break;
				}
				if ((++count) % 9 == 0) {
					list.add(faculty);
					faculty = new Faculty();
				}
				count = count % 9;	
			}
    		
    	}
		 
		return list;
	}
}
