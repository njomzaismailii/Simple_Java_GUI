package sample.sems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin extends Application {
    public static Object language;
    private Label ID = new Label("ID:");
    private TextField id = new TextField();
    private Label Lenda = new Label("Lenda:");
    private TextField lenda = new TextField();
    private Label Nota = new Label("Nota:");
    private TextField nota = new TextField();

    private Label ects = new Label("ECTS:");
    private TextField ECTS = new TextField();

    private TableView tabela = new TableView();

    String ProfEmri;

    public Admin(String rezultati) {
        this.ProfEmri = rezultati;
    }

    public void showNota() {
        ArrayList<DataAdmin> dataAdmin = DataAdmin.getDataAdmin(ProfEmri);

        ObservableList<DataAdmin> dataAdminList = FXCollections.observableArrayList();

        for(int i = 0; i < dataAdmin.size(); i++) {
            dataAdminList.add(dataAdmin.get(i));
        }

        tabela.setItems(dataAdminList);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuBar menubar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exit.setOnAction(e->{
            System.exit(0);
        });
        file.getItems().add(exit);
        menubar.getMenus().add(file);

        GridPane gridpane = new GridPane();

        gridpane.addRow(0, ID, id);
        gridpane.addRow(1, Lenda, lenda);
        gridpane.addRow(2, ects, ECTS);
        gridpane.addRow(3, Nota, nota);

        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e->{
            if(DataAdmin.deleteNota(id.getText(), lenda.getText())) {
                showNota();
            }
        });

        Button btnClear = new Button("Clear All");
        btnClear.setOnAction(e->{
            id.clear();
            ECTS.clear();
            lenda.clear();
            nota.clear();
        });
        Button btnUpdate = new Button("PUSH");
        btnUpdate.setOnAction(e->{
            try
            {
                String query = "SELECT * FROM Notat WHERE Stud_ID = ? AND Lenda = ?";
                PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
                preparedStatement.setString(1, id.getText());
                preparedStatement.setString(2, lenda.getText());

                ResultSet result = preparedStatement.executeQuery();

                if(result.next())
                {
                    if(DataAdmin.updateNota(id.getText(), lenda.getText(), Integer.parseInt(nota.getText()))) {
                        showNota();
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Unsuccessful");
                        alert.setHeaderText(null);
                        alert.setContentText("Data was NOT updated in DB!");
                        alert.showAndWait();
                    }
                }
                else
                {
                    if(DataAdmin.insertNota(id.getText(), lenda.getText(), Integer.parseInt(ECTS.getText()), ProfEmri, Integer.parseInt(nota.getText()))) {
                        showNota();
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Unsuccessful");
                        alert.setHeaderText(null);
                        alert.setContentText("Student with this ID does not exist!");
                        alert.showAndWait();
                    }
                }
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        });

        HBox butonat1 = new HBox();
    	HBox butonat2 = new HBox();
        butonat1.getChildren().addAll(btnClear,btnUpdate,btnDelete);
        butonat1.setSpacing(10);
		butonat2.getChildren().addAll(btnDelete,btnUpdate);
     	butonat2.setSpacing(10);
        gridpane.addRow(4,butonat1);

        gridpane.setHgap(10);
        gridpane.setVgap(10);

        TableColumn<String, Data> column1 = new TableColumn<>("Stud_ID");
        column1.setCellValueFactory(new PropertyValueFactory("Stud_ID"));
        column1.setPrefWidth(150);

        TableColumn<String, Data> column2 = new TableColumn<>("Lenda");
        column2.setCellValueFactory(new PropertyValueFactory("Lenda"));
        column2.setPrefWidth(200);

        TableColumn<String, Data> column3 = new TableColumn<>("ECTS");
        column3.setCellValueFactory(new PropertyValueFactory("ECTS"));
        column3.setPrefWidth(60);

        TableColumn<String, Data> column4 = new TableColumn<>("Nota");
        column4.setCellValueFactory(new PropertyValueFactory("Nota"));
        column4.setPrefWidth(60);


        tabela.getColumns().add(column1);
        tabela.getColumns().add(column2);
        tabela.getColumns().add(column3);
        tabela.getColumns().add(column4);


        tabela.setPrefWidth(470);
        tabela.setPrefHeight(200);
        tabela.maxHeight(200);
        tabela.maxWidth(470);

        ArrayList<DataAdmin> dataAdmin = DataAdmin.getDataAdmin(ProfEmri);

        ObservableList<DataAdmin> dataAdminList = FXCollections.observableArrayList();

        for(int i = 0; i < dataAdmin.size(); i++) {
            dataAdminList.add(dataAdmin.get(i));
        }
        tabela.setItems(dataAdminList);

        VBox menupane = new VBox();
        HBox pane = new HBox(20);

        pane.getChildren().addAll(gridpane, tabela);
        pane.setPadding(new Insets(15, 15, 15 ,15));

        menupane.getChildren().addAll(menubar, pane);

        Scene scene = new Scene(menupane);

        primaryStage.setTitle("SEMS");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}