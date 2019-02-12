package dao_kadai;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public UserBeans findByLoginInfo(String loginId, String password) {

		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");

			return new UserBeans(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
    public List<UserBeans> findAll() {
        Connection conn = null;
        List<UserBeans> userList = new ArrayList<UserBeans>();

        	try {
        		conn = DBManager.getConnection();

        		String sql = "SELECT * FROM user where id >1";
        		Statement stmt = conn.createStatement();
        		ResultSet rs = stmt.executeQuery(sql);

        		while (rs.next()) {
        			int id = rs.getInt("id");
                    String loginId = rs.getString("login_id");
                    String name = rs.getString("name");
                    Date birthDate = rs.getDate("birth_Date");
                    String password = rs.getString("password");
                    String createDate = rs.getString("create_Date");
                    String updateDate = rs.getString("update_Date");
                    UserBeans user = new UserBeans(id, loginId, name, birthDate,password, createDate,updateDate);

                    userList.add(user);
        		}
        	}catch (SQLException e) {
                e.printStackTrace();
                return null;
        	} finally {
        		if (conn != null) {
        			try {
        				conn.close();
        			} catch(SQLException e) {
        				e.printStackTrace();
        				return null;
        			}
        		}
        	}
        	return userList;
    }

    public void newregi(String loginId, String password, String username, String dateofbirth){
        Connection conn = null;
    	// データベースへ接続
        try {
        conn = DBManager.getConnection();
        // INSERT文を準備
      //文字列結合（＋のことだよ）してSQL文をつなぐ時にとは半角スペースがあることを確認します。
        String sql = "INSERT INTO User(login_id, name, birth_date, password, create_date, update_date) VALUES (?,?,?,?, now(), now())";
        // INSERTを実行
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, loginId);
        stmt.setString(2, username);
        stmt.setString(3, dateofbirth);
        stmt.setString(4, password);

        stmt.executeUpdate();

        stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}

