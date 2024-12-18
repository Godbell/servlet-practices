package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.vo.GuestBookVo;
public class GuestBookDao {
    public List<GuestBookVo> findAll() {
        List<GuestBookVo> result = new ArrayList<>();
        try (
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                """
                    SELECT
                        id, name, DATE_FORMAT(reg_date, '%Y-%m-%d %h:%i:%s') AS reg_date, contents
                    FROM guestbook
                    ORDER BY reg_date DESC;
                    """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                GuestBookVo vo = new GuestBookVo();
                vo.setId(resultSet.getLong("id"));
                vo.setName(resultSet.getString("name"));
                vo.setPassword(resultSet.getString("reg_date"));
                vo.setContents(resultSet.getString("contents"));

                result.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
        }

        return result;
    }

    public void insert(GuestBookVo vo) {
        try (
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                """
                    INSERT INTO guestbook (name, password, contents, reg_date) VALUES (?, ?, ?, current_time());
                    """
            );
        ) {
           preparedStatement.setString(1, vo.getName());
           preparedStatement.setString(2, vo.getPassword());
           preparedStatement.setString(3, vo.getContents());
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            String url = "jdbc:mariadb://192.168.64.30:3306/webdb";
            conn = DriverManager.getConnection(url, "webdb", "webdb");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패:" + e);
        }

        return conn;
    }

    public void deleteByIdAndPassword(Long id, String password) {
        try (
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                """
                    DELETE FROM guestbook WHERE id=? AND password=?;
                    """
            );
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
        }
    }
}
