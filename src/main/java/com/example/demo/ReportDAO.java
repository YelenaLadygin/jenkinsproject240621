package com.example.demo;
import java.sql.*;
import java.util.ArrayList;

public class ReportDAO {

        private String m_conn;

        public ReportDAO(String m_conn) {
            this.m_conn = m_conn;
        }

        public void insertReport(ReportDTO c) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {

                    String sql = String.format("INSERT INTO Reports (License_Plate, Driver_Id, Speed) " +
                            "VALUES ( '%s', %d, %d )", c.getLicense_plate(), c.getDriver_id(), c.getSpeed());
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateReport(ReportDTO c, int Id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format(
                            "UPDATE Reports set License_Plate = '%s', Driver_Id = %d, Speed = %d " +
                                    " WHERE Id = %d"
                            , c.getLicense_plate(), c.getDriver_id(), c.getSpeed(), Id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void deleteReport(int Id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format("DELETE from Reports where Id = " + Id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public ArrayList<ReportDTO> getAllReports(){

            ArrayList<ReportDTO> reports = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {
                    String sql = "SELECT * FROM Reports";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        ReportDTO e = new ReportDTO(
                                rs.getInt("Id"),
                                rs.getString("License_Plate"),
                                rs.getInt("Driver_Id"),
                                rs.getInt("Speed"));
                        reports.add(e);
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return  reports;
        }

        public ReportDTO getReportById(int Id){

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {

                    String sql = String.format("Select * from Reports where Id = %d", Id );
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        ReportDTO e = new ReportDTO(
                                rs.getInt("Id"),
                                rs.getString("License_Plate"),
                                rs.getInt("Driver_Id"),
                                rs.getInt("Speed"));
                        return e;
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
