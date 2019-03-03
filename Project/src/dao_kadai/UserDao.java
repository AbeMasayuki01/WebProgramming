package dao_kadai;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class UserDao {
	public UserBeans findByLoginInfo(String loginId, String password) {

		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, encrypt(password));
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
//以下、ログインセッションの時に保持しているデータ
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
//1じゃないとき  id != 1

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

    public List<UserBeans> findSearch(String loginIdP, String nameP, String dateofbirthPabove, String dateofbirthPbelow) {
        Connection conn = null;
        List<UserBeans> userList = new ArrayList<UserBeans>();

        	try {
        		conn = DBManager.getConnection();
//1じゃないとき  id != 1

        		String sql = "SELECT * FROM user where id >1";

        		if(!loginIdP.isEmpty()) {
        			sql += " AND login_id = '"+ loginIdP + "'";
        		}
        		if(!nameP.isEmpty()) {
        			sql += " AND name LIKE '"+ '%'+ nameP +'%' + "'";
        		}
        		if(!dateofbirthPabove.isEmpty()) {
        			sql += " AND birth_Date >= '"+ dateofbirthPabove + "'";
        		}
        		if(!dateofbirthPbelow.isEmpty()) {
        			sql += " AND birth_Date <= '"+ dateofbirthPbelow + "'";
        		}

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

    public void newregi(String loginId, String password, String username, String dateofbirth)
    throws SQLException{
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
        stmt.setString(4, encrypt(password));
        //

        stmt.executeUpdate();

        stmt.close();


            //throwでサーブレット内での処理に移行
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

    public UserBeans findById(String id) {
        Connection conn = null;

        try {
			conn = DBManager.getConnection();

			String sql ="SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);

			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int iD = rs.getInt("id");
            String loginId = rs.getString("login_id");
            String name = rs.getString("name");
            Date birthDate = rs.getDate("birth_Date");
            String password = rs.getString("password");
            String createDate = rs.getString("create_Date");
            String updateDate = rs.getString("update_Date");

			return new UserBeans(iD, loginId, name, birthDate, password, createDate, updateDate);

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
    public void deleteById(String id) {
        Connection conn = null;

        try {
			conn = DBManager.getConnection();

			String sql ="DELETE FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);

			pStmt.executeUpdate();


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

    public void updateById(String id, String password, String name, String birth_date) {
        Connection conn = null;

        try {
			conn = DBManager.getConnection();

			String sql ="UPDATE user SET password = ? , name=? , birth_date =? , update_date= now() WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,encrypt(password));
			pStmt.setString(2,name);
			pStmt.setString(3,birth_date);
			pStmt.setString(4,id);


			pStmt.executeUpdate();


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
    public void updateById(String id, String name, String birth_date) {
        Connection conn = null;

        try {
			conn = DBManager.getConnection();

			String sql ="UPDATE user SET name=? , birth_date =? , update_date= now() WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,name);
			pStmt.setString(2,birth_date);
			pStmt.setString(3,id);


			pStmt.executeUpdate();


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
    private String encrypt(String password) {
    	//ハッシュ生成前にバイト配列に置き換える際のCharset
    	Charset charset = StandardCharsets.UTF_8;
    	//ハッシュアルゴリズム
    	String algorithm = "MD5";

    	//ハッシュ生成処理
    	byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	String result = DatatypeConverter.printHexBinary(bytes);


    	return result;
    }

}

