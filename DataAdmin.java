package sample.sems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAdmin {
    private String Stud_ID;
    private String Lenda;
    private int ECTS;
    private int Nota;

    public DataAdmin(String Stud_ID, String Lenda, int ECTS, int Nota) {
        this.Stud_ID = Stud_ID;

        this.Lenda = Lenda;
        this.ECTS = ECTS;
        this.Nota = Nota;
    }

    public String getStud_ID() {
        return Stud_ID;
    }

    public void setStud_ID(String stud_ID) {
        Stud_ID = stud_ID;
    }

    public String getLenda() {
        return Lenda;
    }

    public void setLenda(String lenda) {
        Lenda = lenda;
    }

    public int getECTS() {
        return ECTS;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int nota) {
        Nota = nota;
    }

    public static boolean updateNota(String Stud_ID, String Lenda, int Nota) {
        String query = "UPDATE Notat SET Nota=? WHERE Stud_ID=? AND Lenda=?";

        try {
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);

            preparedStatement.setInt(1, Nota);
            preparedStatement.setString(2, Stud_ID);
            preparedStatement.setString(3, Lenda);

            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean deleteNota(String Stud_ID, String Lenda) {
        String query = "DELETE FROM Notat WHERE Stud_ID = ? AND Lenda = ?";

        try {
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);

            preparedStatement.setString(1, Stud_ID);
            preparedStatement.setString(2, Lenda);

            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean insertNota(String Stud_ID, String Lenda, int ECTS, String Profesori, int Nota) {
        String query = "INSERT INTO Notat(Stud_ID, Lenda, ECTS, Profesori, Nota) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);

            preparedStatement.setString(1, Stud_ID);
            preparedStatement.setString(2, Lenda);
            preparedStatement.setInt(3, ECTS);
            preparedStatement.setString(4, Profesori);
            preparedStatement.setInt(5, Nota);

            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<DataAdmin> getDataAdmin(String ProfEmri) {
        ArrayList<DataAdmin> dataAdminList = new ArrayList<>();

        try {
            String query = "Select * from Notat WHERE Profesori = ?";
            PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ProfEmri);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                DataAdmin dataAdmin = new DataAdmin(result.getString(1), result.getString(2), result.getInt(3),
                        result.getInt(5));
                dataAdminList.add(dataAdmin);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dataAdminList;
    }
}