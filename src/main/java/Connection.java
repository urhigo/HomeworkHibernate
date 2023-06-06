import Pets.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Connection {

    public Connection() {
    }

    public List<Pet> lookAll() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Pet.class);
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
        List<Pet> listPets;
        Session sessionSelectAll = sessionFactory.openSession();
        Transaction trLookAll = sessionSelectAll.beginTransaction();
        Query query = sessionSelectAll.createQuery("FROM Pets.Pet");
        listPets = query.list();
        trLookAll.commit();
        sessionSelectAll.close();
        return listPets;
    }

    public List<Pet> lookOne(int id) {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Pet.class);
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
        List<Pet> listPets;
        Session sessionSelectOne = sessionFactory.openSession();
        Transaction trLookOne = sessionSelectOne.beginTransaction();
        Query query = sessionSelectOne.createQuery("FROM Pets.Pet where id = :paramName");
        query.setParameter("paramName", id);
        listPets = query.list();
        trLookOne.commit();
        sessionSelectOne.close();
        return listPets;
    }

    public void updatePet(int oldId, int id, int age, String type, String name) {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Pet.class);
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
        Session sessionUpdate = sessionFactory.openSession();
        Transaction trUpdate = sessionUpdate.beginTransaction();

        String hql = "UPDATE Pets.Pet "
                + "SET id = :idParam,"
                + "type = :typeParam "
                +   ", name = :nameParam "
                +   ", age = :ageParam "
                +  " where id = :idOldParam";

        Query queryUpdate = sessionUpdate.createQuery(hql);

        queryUpdate.setParameter("idOldParam" , oldId);
        queryUpdate.setParameter("idParam" , id);
        queryUpdate.setParameter("typeParam" , type);
        queryUpdate.setParameter("nameParam" , name);
        queryUpdate.setParameter("ageParam" , age);

        queryUpdate.executeUpdate();

        trUpdate.commit();
        sessionUpdate.close();

    }

    public void delete (int id){
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Pet.class);
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());

        Session sessionDelete = sessionFactory.openSession();
        Transaction trDelete = sessionDelete.beginTransaction();

        String hql = "DELETE Pets.Pet WHERE id = :idParam";
        Query queryDelete = sessionDelete.createQuery(hql);
        queryDelete.setParameter("idParam", id);

        queryDelete.executeUpdate();

        trDelete.commit();
        sessionDelete.close();
    }


}
