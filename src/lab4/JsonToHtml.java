package lab4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class JsonToHtml
 */
@WebServlet("/JsonToHtml")
public class JsonToHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Request from /JsonToHtml
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		JsonFormatter jsonFormatter = new JsonFormatter();
		JsonToHtmlController controller = new JsonToHtmlController();
		String jsonString = controller.getJsonString();
		
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Boolean pretty = Boolean.valueOf(request.getParameter("pretty"));
            
            if (pretty)
            	out.println(jsonFormatter.format(jsonString));
            else
            	out.println(jsonString);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Json string.";
    }

}
