package sample.sems;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Locale;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Login_Register extends Application {

    TextField txtUser = new TextField();
    PasswordField txtPass = new PasswordField();
    Stage stage = new Stage();




    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane pane = new TabPane();
        pane.setMinSize(800, 600);
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        Tab loginTab = new Tab("Login", showLoginScreen());
        loginTab.setClosable(false);

        Tab registerTab = new Tab("Register",gridPane);
        registerTab.setClosable(false);

        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);

        pane.getTabs().addAll(loginTab, registerTab);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(pane);

        // Set the scene in primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration");
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and
        // horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {


        ComboBox<String> language = new ComboBox<String>(FXCollections.observableArrayList("AL", "EN"));

        VBox hbLanguage = new VBox();

        Label gjuha = new Label("Gjuha");
        gjuha.setStyle("-fx-font-weight: bold; -fx-font-size: 15px ");



        hbLanguage.getChildren().addAll(gjuha,language);
        hbLanguage.setSpacing(15);

        language.setValue("EN");

        language.setOnAction(e->
        {
            Language.setLocale(new Locale(language.getValue().toLowerCase()));
        });

        hbLanguage.setAlignment(Pos.TOP_LEFT);
        hbLanguage.setPadding(new Insets(20,20,20,20));


        gridPane.add(hbLanguage,0,0, 5, 1);
        hbLanguage.setTranslateX(-40);
        //hbLanguage.setTranslateX(630); //nese e doon nekrahe te djathte
        hbLanguage.setTranslateY(-100);

        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        // Add Name Label
        Label nameLabel = new Label("Full Name:");
        gridPane.add(nameLabel, 0, 1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);

        // Add Email Label
        Label idLabel = new Label("ID number:");
        gridPane.add(idLabel, 0, 2);
        TextField idField = new TextField(); // Add ID Text Field
        idField.setPrefHeight(40);
        gridPane.add(idField, 1, 2);


        // Add Password Label
        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 3);
        PasswordField passwordField = new PasswordField();// Add Password Field
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        Label bdayLabel = new Label("Birthday:");
        DatePicker bdayPicker = new DatePicker();
        gridPane.add(bdayLabel, 0, 4);
        gridPane.add(bdayPicker, 1, 4, 2, 1);

        // language
        Label languagesLabel = new Label("Known languages:");
        CheckBox javaCheckBox = new CheckBox("Java");
        CheckBox cppCheckBox = new CheckBox("C++");
        CheckBox csharpCheckBox = new CheckBox("C#");
        CheckBox pythonCheckBox = new CheckBox("Python");
        gridPane.add(languagesLabel, 0, 5);
        gridPane.add(new HBox(15, javaCheckBox, cppCheckBox, csharpCheckBox, pythonCheckBox), 1, 5, 2, 1);

        // radiobutton
        Label genderLabel = Language.getLabel("Gender");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton femaleRadioButton= new RadioButton("Female");
        RadioButton maleRadioButton = new RadioButton("Male");
        femaleRadioButton.setToggleGroup(genderGroup);
        maleRadioButton.setToggleGroup(genderGroup);
        gridPane.add(genderLabel, 0, 6);
        gridPane.add(new HBox(15, femaleRadioButton, maleRadioButton), 1, 6, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 7, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 100, 20, 0));

        // clear button
        Button clearButton = new Button("Clear");
        clearButton.setPrefSize(100, 40);
        clearButton.setDefaultButton(true);
        gridPane.add(clearButton, 1, 7, 2, 1);
        GridPane.setHalignment(clearButton, HPos.CENTER);
        GridPane.setMargin(clearButton, new Insets(20, 0, 20, 20));

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameField.setText("");
                idField.setText("");
                passwordField.setText("");
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
                            "Please enter your name!");
                    return;
                }
                if (idField.getText().isEmpty() | idField.getLength() < 5 ) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
                            "Please enter your ID number!");
                    return;
                }
                if (passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
                            "Please enter a password!");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!",
                        "Welcome " + nameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void loginUser(TextField txtUser,TextField txtPass)
    {
        String query = "SELECT * FROM Login WHERE Stud_ID = ? AND Stud_Password= ?";
        String queryprof = "SELECT * FROM Profesori WHERE Profesori = ? AND Prof_Password= ?";

        try {
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(queryprof);
            preparedStatement.setString(1, txtUser.getText());
            preparedStatement.setString(2, txtPass.getText());

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                Admin admin = new Admin(txtUser.getText());
                admin.start(stage);
            }
            else
            {
                preparedStatement = Databaza.getConnection().prepareStatement(query);
                preparedStatement.setString(1, txtUser.getText());
                preparedStatement.setString(2, txtPass.getText());
                result = preparedStatement.executeQuery();

                if(result.next())
                {
                    Kryesore kryesore = new Kryesore(txtUser.getText());
                    kryesore.start(stage);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Login result");
                    alert.setHeaderText(null);
                    alert.setContentText("ID or password is wrong!");
                    alert.showAndWait();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public Node showLoginScreen() throws FileNotFoundException
    {
        StackPane pane = new StackPane();
        Rectangle rectangle = new Rectangle(0,0,800, 600);
        rectangle.setStyle("-fx-stroke:blue;-fx-border:10px;-fx-border-color:red;-fx-stroke-width:5;-fx-fill:lightblue;-fx-border-radius:50px;");
        Region rekt = new Region();
        rekt.setMaxSize(500, 500);
        rekt.setStyle("-fx-border: 10px;-fx-background-color:transparent;-fx-border-color:blue;-fx-border-radius: 10px;");
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.WHITE);
        shadow.setRadius(50);

        rectangle.setEffect(shadow);
        pane.setPadding(new Insets(5,5,5,5));
        pane.getChildren().add(rectangle);
        pane.getChildren().add(rekt);

        VBox vbox = new VBox();
        Image image = new Image(new FileInputStream("Foto/universiteti-logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        txtUser.setPrefColumnCount(1);
        txtUser.setMaxWidth(200);
        txtUser.setPromptText(new Label("Username").getText());
        txtUser.setStyle("-fx-border-color:black");
        txtPass.setPrefColumnCount(1);
        txtPass.setMaxWidth(200);
        txtPass.setPromptText(new Label("Password").getText());
        txtPass.setStyle("-fx-border-color:black");
        Button btnLogin =new Button("Login");
        btnLogin.setStyle("-fx-border-color:black;");
        Platform.runLater(()->imageView.requestFocus());

        btnLogin.setOnMouseEntered(e->{
            btnLogin.setCursor(Cursor.HAND);
        });
        btnLogin.setOnMouseClicked(e->{
            loginUser(txtUser,txtPass);
        });

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);



        /* --- Kodi per ComboBox --- */


        ComboBox<String> language = new ComboBox<String>(FXCollections.observableArrayList("AL", "EN"));

        VBox hbLanguage = new VBox();

        Label gjuha = new Label("Gjuha");
        gjuha.setStyle("-fx-font-weight: bold; -fx-font-size: 15px ");

        hbLanguage.getChildren().addAll(gjuha,language);
        hbLanguage.setSpacing(15);

        language.setValue("EN");

        language.setOnAction(e->
        {
            Language.setLocale(new Locale(language.getValue().toLowerCase()));
            txtPass.setPromptText(Language.getLabel("Password").getText());
            txtUser.setPromptText(Language.getLabel("Username").getText());
        });


        txtPass.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                loginUser(txtUser,txtPass);
            }
        });

        txtUser.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                loginUser(txtUser,txtPass);
            }
        });


        hbLanguage.setTranslateX(30);
        //hbLanguage.setTranslateX(630); //nese e dojm ta bejme ne anen e djathte
        hbLanguage.setTranslateY(-480);


        vbox.setPadding(new Insets(50,0,0,0));
        vbox.getChildren().addAll(imageView,txtUser,txtPass,btnLogin,hbLanguage);

        pane.getChildren().addAll(vbox);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
