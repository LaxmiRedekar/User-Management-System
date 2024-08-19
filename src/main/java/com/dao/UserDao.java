package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.model.Admin;
import com.model.User;

public class UserDao {
	//Quary
	private static String insert = "insert into user(name,email,city) values(?,?,?)";
	private static String display = "select * from user"; 
	private static String delete = "delete from user where id=?";
	private static String edit = "select * from user where id=?";
	private static String update = "update user set name=?,email=?,city=? where id=?";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet res = null;
	private static Statement stm = null;
	
	
	
	//insert data into database
	public static void insert(User user) {
		
		try {
			//step 1 : Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 : Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
			
			ps = con.prepareStatement(insert);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCity());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
	}
	
	//Display user data
	public static ArrayList<User> display() {
		ArrayList<User> al = new ArrayList<User>();
		
		 try {
				//step 1 : Load Driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//step2 : Establish Connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
				
				stm = con.createStatement();
				res = stm.executeQuery(display);
				while(res.next()) {
					int id = res.getInt("id") ;
					String name = res.getString("name");
					String email = res.getString("email");
					String city = res.getString("city");
					
					User user = new User(id, name, email, city);
					al.add(user);
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if(res != null) {
					try {
						res.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
				if(stm != null) {
					try {
						stm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
			}
		return al;
			
	}

	//delete the user data based on id
	public static void delete(int id) {
		
		try {
			//step 1 : Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 : Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
			
			ps = con.prepareStatement(delete);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
	}

	public static User edit(int id) {
		User user = null;
		try {
			//step 1 : Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 : Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
			
			ps = con.prepareStatement(edit);
			ps.setInt(1, id);
			
			res=ps.executeQuery();
			res.next();
			int iD = res.getInt("id");
			String name = res.getString("name");
			String email = res.getString("email");
			String city = res.getString("city");
			
			user = new User(iD, name, email, city);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
		return user;
		
	}

	//update user data 
	public static void update(User user) {
		try {
			//step 1 : Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 : Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
			
			ps = con.prepareStatement(update);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCity());
			ps.setInt(4, user.getId());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
		
	}


	public String checkLogin(Admin a) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
			stm = con.createStatement();
			res = stm.executeQuery("select * from admin");
			
			while(res.next()) {
				String email = res.getString("email");
				String dpwd= res.getString("pwd");
				
				if(email.equals(a.getEmail()) && dpwd.equals(a.getPwd())) {
					return "success";
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "failure";
	}
}
