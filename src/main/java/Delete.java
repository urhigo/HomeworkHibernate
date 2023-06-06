import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idText = request.getParameter("id");
        if (StringUtils.isNumeric(idText)) {
            int id = Integer.parseInt(idText);
            Connection connection = new Connection();
            connection.delete(id);
            getServletContext().getRequestDispatcher("/CompliteUpdateOrDelete.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/LookOneDelete.jsp").forward(request, response);
        }
    }

}
