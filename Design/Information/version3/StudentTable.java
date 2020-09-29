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
import version2.Student;
/**
 * 学生信息管理界面
 * @author 周明华
 *
 */
public class StudentTable extends Application {
    private final TableView<Student> table = new TableView<>();
   
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		
		ArrayList<Student> list = new ArrayList<>();
		try {
			list = readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObservableList<Student> data = FXCollections.observableArrayList(list);
		 
        Scene scene = new Scene(new Group());
        stage.setTitle("学生信息管理");
        stage.setWidth(800);
        stage.setHeight(500);

        table.setEditable(true);
        
        TableColumn<Student, String> nameCol = new TableColumn<>("姓名");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//数据关联到表格
        
        TableColumn<Student, String> adressCol = new TableColumn<>("地址");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));//数据关联到表格
        
        TableColumn<Student, String> phoneNumberCol = new TableColumn<>("电话号码");
        phoneNumberCol.setMinWidth(200);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));//数据关联到表格
        
        TableColumn<Student, String> emailCol = new TableColumn<>("电子邮件");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));//数据关联到表格
        
        TableColumn<Student, Integer> gradeCol = new TableColumn<>("年级");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));//数据关联到表格
        
        table.setItems(data);//向表中添加数据
        table.getColumns().addAll(nameCol, adressCol, phoneNumberCol, emailCol, gradeCol);
        
        Button addButton = new Button("增加");
        addButton.setMinSize(50, 20);
        addButton.setOnAction(event -> {
        	AddStudent addStudent = new AddStudent();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
				addStudent.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button deletButton = new Button("删除");
        deletButton.setMinSize(50, 20);
        deletButton.setOnAction(event -> {
        	DeleteStudentSearch deleteStudentSearch = new DeleteStudentSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		deleteStudentSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button changeButton = new Button("修改");
        changeButton.setMinSize(50, 20);
        changeButton.setOnAction(event -> {
        	ChangeStudentSearch changeStudentSearch = new ChangeStudentSearch();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		changeStudentSearch.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });	
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	SearchStudent searchStudent = new SearchStudent();
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(400);
    		newStage.setMinHeight(300);
    		
        	try {
        		searchStudent.start(newStage);
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
	 * @return Student 对象链表
	 * @throws FileNotFoundException
	 */
	public ArrayList<Student> readFile() throws FileNotFoundException {
    	
    	ArrayList<Student> list = new ArrayList<>();
    	Student student = new Student();
    	
    	try(Scanner input = new Scanner(new File("student.txt"));) {
    		int count = 0;
    		int index = 0;
    		while (input.hasNext()) {
				String string = input.next();
				switch (count) {
				case 0:
					if (index == 0) {
						string = string.substring(1);
						index++;
					}
					student.setName(string);
					break;
				case 1:
					student.setAddress(string);
					break;
				case 2:
					student.setPhoneNumber(string);
					break;
				case 3:
					student.setEmail(string);
					break;
				case 4:
					student.setGrade(string);
					break;					
				default:
					break;
				}
				if ((++count) % 5 == 0) {
					list.add(student);
					student = new Student();
				}
				count = count % 5;	
			}
    		
    	}
		 
		return list;
	}
}
