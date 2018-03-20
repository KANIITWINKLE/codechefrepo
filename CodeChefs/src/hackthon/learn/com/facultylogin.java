package hackthon.learn.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class facultylogin
 */
@WebServlet("/run1")
public class facultylogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public facultylogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 String url = "jdbc:mysql://localhost:3306/contactdb";
	        String user = "root";
	        String password = "secret";
	 
	        String filePath = "D:/Photos/Tom.jpg";
	 
	        try {
	            Connection conn = DriverManager.getConnection(url, user, password);
	 
	            String sql = "SELECT photo FROM person WHERE first_name=? AND last_name=?";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, "Tom");
	            statement.setString(2, "Eagar");
	 
	            ResultSet result = statement.executeQuery();
	            if (result.next()) {
	                Blob blob = result.getBlob("photo");
	                InputStream inputStream = blob.getBinaryStream();
	                OutputStream outputStream = new FileOutputStream(filePath);
	 
	                int bytesRead = -1;
	                byte[] buffer = new byte[buffer_size]];
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	 
	                inputStream.close();
	                outputStream.close();
	                System.out.println("File saved");
	            }
	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        request.setAttribute("attendance",attendance);
            getServletContext().getRequestDispatcher("/attendance.html")
                .include(request, response);
	    }
	}

