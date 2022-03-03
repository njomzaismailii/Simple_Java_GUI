package sample.sems;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Kryesore extends Application {
    public static Object language;
    String Emri;
    String Mbiemri;
    String Fakulteti;
    String Departamenti;
    String ID;
    String VitiRegjistrimit;
    String VitiLindjes;
    String VendiLindjes;
    String MbaroiStudimet;
    String Titulli;
    String NotaMesatare;
    int ECTSTotal;

    private TableView tabela = new TableView();

    public Kryesore(String rezultati) {
        this.ID = rezultati;
    }
    public void aplikimi()
    {
        Document document = new Document();

        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C://Users//Njomza//Desktop//Njomza//"+Emri+"_"+Mbiemri+".pdf"));
            document.open();
            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(new float[]{ 240, 260 });
            table.setLockedWidth(true);
            PdfContentByte cb = writer.getDirectContent();

            Font fontsize = FontFactory.getFont(FontFactory.HELVETICA,10);

            PdfPCell cell = new PdfPCell();
            cell.setFixedHeight(35);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);
            // first row
            cell = new PdfPCell(new Paragraph("Republika e Kosoves",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Republic of Kosovo",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);

            // second row
            cell = new PdfPCell(new Paragraph("Universiteti i Prishtines",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("University of Prishtina",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            // third row
            cell = new PdfPCell(new Paragraph("\"Hasan Prishtina\"",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("\"Hasan Prishtina\"",fontsize));
            cell.setFixedHeight(25);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //4th row
            cell = new PdfPCell(new Paragraph(Fakulteti,fontsize));
            cell.setFixedHeight(40);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(Fakulteti,fontsize));
            cell.setFixedHeight(40);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //5th row
            fontsize = FontFactory.getFont(FontFactory.COURIER,55);
            cell = new PdfPCell(new Paragraph("DIPLOME",fontsize));
            cell.setFixedHeight(80);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("DIPLOMA",fontsize));
            cell.setFixedHeight(80);
            cell.setIndent(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //6th row
            fontsize = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
            cell = new PdfPCell(new Paragraph(Emri+" "+Mbiemri,fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);
            //7th row
            fontsize = FontFactory.getFont(FontFactory.HELVETICA,8);
            cell = new PdfPCell(new Paragraph("U lind me "+VitiLindjes+" ne "+VendiLindjes,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Born on "+VitiLindjes+" in "+VendiLindjes,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //8th row

            //9th row
            cell = new PdfPCell(new Paragraph("U regjistrua ne vitin akademik "+VitiRegjistrimit,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Was enrolled in the academic year "+VitiRegjistrimit,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //10th row
            cell = new PdfPCell(new Paragraph("Studimet i mbaroi me "+MbaroiStudimet,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Completed his/her studies on "+MbaroiStudimet,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //10th row
            cell = new PdfPCell(new Paragraph(Departamenti,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(Departamenti,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //11th row
            cell = new PdfPCell(new Paragraph("dhe mori titullin:",fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("and was awarded with this title:",fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //12th row
            cell = new PdfPCell(new Paragraph(Titulli,fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(Titulli,fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //13th row
            cell = new PdfPCell(new Paragraph("Gjithsej "+ECTSTotal+" - ECTS",fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Total "+ECTSTotal+" - ECTS",fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //14th row
            cell = new PdfPCell(new Paragraph("Nota mesatare gjate studimeve "+NotaMesatare,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Average grade of studies "+NotaMesatare,fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //15th row
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            cell = new PdfPCell(new Paragraph(formatter.format(date),fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(formatter.format(date),fontsize));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setIndent(20);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            //16th row
            cell = new PdfPCell(new Paragraph("   Dekani",fontsize));
            cell.setFixedHeight(40);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Rektori \t",fontsize));
            cell.setFixedHeight(40);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("___________",fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("___________",fontsize));
            cell.setFixedHeight(30);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);

            document.add(table);


            Image img = Image.getInstance("Foto/universiteti-logo.png");
            img.setAbsolutePosition(70f, 700f);
            img.scaleAbsolute(70, 70);
            document.add(img);

            img = Image.getInstance("Foto/Kosovo-logo.png");
            img.setAbsolutePosition(450f, 700f);
            img.scaleAbsolute(70, 70);
            document.add(img);
            img = Image.getInstance("Foto/diploma.png");
            img.setAbsolutePosition(228f, 230f);
            img.scaleAbsolute(146, 69);
            document.add(img);

            document.close();

        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try
        {
            String query = "SELECT AVG(Nota) FROM Notat WHERE Stud_ID = ?";

            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ID);

            ResultSet result = preparedStatement.executeQuery();
            result.next();

            NotaMesatare = result.getString(1);

            query = "SELECT SUM(ECTS) FROM Notat WHERE Stud_ID = ?";
            preparedStatement = Databaza.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ID);
            result = preparedStatement.executeQuery();
            result.next();

            ECTSTotal = result.getInt(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Popullimi i tabeles me te dhena
        try {
            String query = "SELECT * FROM Studenti WHERE Stud_ID = ?";

            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ID);

            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
            {
                Emri = result.getString("Emri");
                Mbiemri = result.getString("Mbiemri");
                Fakulteti = result.getString("Fakulteti");
                Departamenti = result.getString("Departamenti");
                VitiRegjistrimit = result.getString("VitiRegjistrimit");
                VendiLindjes = result.getString("VendiLindjes");
                VitiLindjes = result.getString("VitiLindjes");
                MbaroiStudimet = result.getString("MbaroiStudimet");
                Titulli = result.getString("Titulli");


            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        Button apliko = new Button("Apliko");

        apliko.setOnAction( e -> {
            try {
                if(ECTSTotal == 60)
                {
                    aplikimi();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Aplikimi Result");
                    alert.setHeaderText(null);
                    alert.setContentText("Ju keni aplikuar me sukses!");
                    alert.showAndWait();
                }
                else
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Aplikimi Result");
                    alert.setHeaderText(null);
                    alert.setContentText("You don't have enough ECTS credits to do this!");
                    alert.showAndWait();
                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        });

        GridPane gridpane = new GridPane();

        gridpane.addRow(1, new Label("Emri: "), new Label(Emri));
        gridpane.addRow(2, new Label("Mbiemri: "), new Label(Mbiemri));
        gridpane.addRow(3, new Label("Vendi i Lindjes: "), new Label(VendiLindjes));
        gridpane.addRow(4, new Label("Viti i Lindjes: "), new Label(VitiLindjes));
        gridpane.addRow(5, new Label("Viti i Regjistrimit: "), new Label(VitiRegjistrimit));
        gridpane.addRow(6, new Label("Fakulteti: "), new Label(Fakulteti));
        gridpane.addRow(7, new Label("Departamenti: "), new Label(Departamenti));
        gridpane.addRow(8, new Label("Mbaroi Studimet: "), new Label(MbaroiStudimet));
        gridpane.addRow(9, new Label("Titulli: "), new Label(Titulli));
        gridpane.addRow(10, new Label("Nota Mesatare: "), new Label(NotaMesatare));


        gridpane.addRow(11, apliko);
        gridpane.setHgap(30);
        gridpane.setVgap(10);


        TableColumn<String, Data> column1 = new TableColumn<>("Lenda");
        column1.setCellValueFactory(new PropertyValueFactory("Lenda"));
        column1.setPrefWidth(150);

        TableColumn<String, Data> column2 = new TableColumn<>("ECTS");
        column2.setCellValueFactory(new PropertyValueFactory("ECTS"));
        column2.setPrefWidth(60);

        TableColumn<String, Data> column3 = new TableColumn<>("Profesori");
        column3.setCellValueFactory(new PropertyValueFactory("Profesori"));
        column3.setPrefWidth(200);

        TableColumn<String, Data> column4 = new TableColumn<>("Nota");
        column4.setCellValueFactory(new PropertyValueFactory("Nota"));
        column4.setPrefWidth(60);


        tabela.getColumns().add(column1);
        tabela.getColumns().add(column2);
        tabela.getColumns().add(column3);
        tabela.getColumns().add(column4);


        tabela.setPrefWidth(472);
        tabela.setPrefHeight(200);
        tabela.maxHeight(200);
        tabela.maxWidth(472);


        ArrayList<Data> data = Data.getData(ID);

        ObservableList<Data> dataList = FXCollections.observableArrayList();

        for(int i = 0; i < data.size(); i++) {
            dataList.add(data.get(i));
        }
        tabela.setItems(dataList);

        HBox pane = new HBox(20);

        pane.getChildren().addAll(gridpane, tabela);
        pane.setPadding(new Insets(15, 15, 15 ,15));

        Scene scene = new Scene(pane);

        primaryStage.setTitle("SEMS");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}