package hackthon.learn.com;

import java.awt.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class captureimage
 * @param <FaceDetector>
 */
@WebServlet("/run2")
public class captureimage<FaceDetector> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public captureimage() {
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
		 PrintWriter out=response.getWriter();
		    Part name=request.getPart("NameBox");
		    Part img=request.getPart("Img");
		    String filename=getFileName(img);
		    InputStream is=img.getInputStream();
		    int i=is.available();
		    byte[] b=new byte[i];
		    is.read(b);
		    String path="E:/temp/"+filename;
		    FileOutputStream os=new FileOutputStream(path);
		     os.write(b);
		    os.close();
		    is.close();
		   FaceDetector fd=new FaceDetector();
		    fd.getFaces(path);  
		}

	private String getFileName(Part img) {
		
		return null;
	}
	public class FaceDetector {

		static
		{
			System.loadLibrary("opencv_java247"); }
		}
		public List getFaces(String url) throws MalformedURLException, IOException
		{
		    Math image = Highgui.imread(url);
		    //code...
		}
	}

