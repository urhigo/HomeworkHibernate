import Pets.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "lookAll", value = "/LookAll")
public class LookAll extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = new Connection();
        List<Pet> listPets = connection.lookAll();
        for (Pet pet: listPets
        ) {
            System.out.println(pet.toString());
        }
        request.setAttribute("listPet", listPets);
        getServletContext().getRequestDispatcher("/LookAll.jsp").forward(request, response);

    }
}
