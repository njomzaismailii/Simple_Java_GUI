package sample.sems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Data {
    private String Stud_ID;
    private String Lenda;
    private String ECTS;
    private String Profesori;
    private String Nota;

    public Data(String Stud_ID,String Lenda, String ECTS, String Profesori, String Nota)
    {
        this.Stud_ID = Stud_ID;
        this.Lenda = Lenda;
        this.ECTS = ECTS;
        this.Profesori = Profesori;
        this.Nota = Nota;
    }

    public String getID() {
        return Stud_ID;
    }

    public String getLenda() {
        return Lenda;
    }

    public void setLenda(String lenda) {
        Lenda = lenda;
    }

    public String getECTS() {
        return ECTS;
    }

    public void setECTS(String eCTS) {
        ECTS = eCTS;
    }

    public String getProfesori() {
        return Profesori;
    }

    public void setProfesori(String profesori) {
        Profesori = profesori;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String nota) {
        Nota = nota;
    }
    public static ArrayList<Data> getData(String ID) {
        ArrayList<Data> dataList = new ArrayList<>();

        try {
            String query = "Select * from Notat WHERE Stud_ID = ?";
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ID);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()) {
                Data data = new Data(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                dataList.add(data);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return dataList;
    }
}
