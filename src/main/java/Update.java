import Pets.Pet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "update", value = "/UpdatePet")
public class Update extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idText = request.getParameter("id");
        String ageText = request.getParameter("age");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        if (StringUtils.isNumeric(ageText) & StringUtils.isNumeric(idText)) {
            int id = Integer.parseInt(idText);
            int age = Integer.parseInt(ageText);
            int oldId = Integer.parseInt(request.getParameter("oldId"));
            Connection connection = new Connection();
            connection.updatePet(oldId, id, age, type, name);
            getServletContext().getRequestDispatcher("/CompliteUpdateOrDelete.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/UpdateInf.jsp").forward(request, response);
        }

    }
}
