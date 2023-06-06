import Pets.Pet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Control", value = "/ControlValue")
public class ControlUpdateInf extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idText = request.getParameter("id");
        if (StringUtils.isNumeric(idText)) {
            int id = Integer.parseInt(idText);
            Connection connection = new Connection();
            List<Pet> listPets = connection.lookOne(id);
            if (listPets.size() == 0) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("id", listPets.get(0).getId());
                request.setAttribute("type", listPets.get(0).getType());
                request.setAttribute("name", listPets.get(0).getName());
                request.setAttribute("age", listPets.get(0).getAge());
                getServletContext().getRequestDispatcher("/UpdateInf.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/LookOneUpdate.jsp").forward(request, response);
        }
    }

}
