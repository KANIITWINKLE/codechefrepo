package hackthon.learn.com;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class registration
 */
@WebServlet("/run")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registration()
    {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		 try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=null;
             try{
                 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","786");
                 PrintWriter out = response.getWriter();
                 response.setContentType("text/html");
                 String s1=request.getParameter("fname");
                 String s2=request.getParameter("lname");
                 String s3=request.getParameter("email");
                 String s4=request.getParameter("mobile");
                 String s5=request.getParameter("pass");
                 String s6=request.getParameter("cpass");
                 String s7=request.getParameter("uf");
                 PreparedStatement ps=con.prepareStatement("insert into facultyRegistration(?,?,?,?,?,?)");
                 ps.setString(1,s1);
                 ps.setString(2,s2);
                 ps.setString(3,s3);
                 ps.setString(4,s4);
                 ps.setString(3,s5);
                 ps.setString(4,s6);
                 File file=new File("+s7+");
                 FileInputStream fis=new FileInputStream(file);
                 int len=(int)file.length();
                 ps.setBinaryStream(4,fis,len);
                 int c=ps.executeUpdate();
                 if(c==0)
                 {
                	 out.println("<Registratin fail");
                	 
                 }
                 else
                 {
                	 out.println("Registration sucssesfull");
                	 }
             }
             finally
             {
            	 if(con!=null)con.close();
            	 }
         }
         catch(ClassNotFoundException ce)
		 {
        	 System.out.println("<h1>Registration Fail");
        	 }
         catch(SQLException se)
		 {
        	System.out.println("<h1>Registration Fail");
        	 }
        System.out.flush();
         System.out.close();
     }
    }
 