import Pets.Pet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "lookOne", value = "/LookOnePet")
public class LookOnePet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idText = request.getParameter("id");
        if (StringUtils.isNumeric(idText)) {
            int id = Integer.parseInt(idText);
            Connection connection = new Connection();
            List<Pet> listPet = connection.lookOne(id);
            request.setAttribute("listPet", listPet);
            getServletContext().getRequestDispatcher("/LookAll.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/IdPet.jsp").forward(request, response);
        }

    }
}
