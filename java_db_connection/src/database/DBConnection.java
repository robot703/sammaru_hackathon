package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial", "root", "cho7031105*");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
        }
    }

    public ArrayList<String> printAdminDataAbove80() {
        try {
            String SQL = "SELECT * FROM admin WHERE Data >= 80 ";
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                String cameraNumber = rs.getString("CameraNumber");
                float dataValue = rs.getFloat("Data");
                System.out.println("CameraNumber: " + cameraNumber + ", Data: " + dataValue);
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
        }
        return null;
    }

}
