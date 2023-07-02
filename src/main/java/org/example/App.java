package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
            //редактирование бд
            //Person person = session.get(Person.class, 2);
            //person.setName("*****");

            // удаление из бд
            //session.delete(person);

            //получить айди нового обьекта
            Person person = new Person("Some name", 22);
            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());
        } finally {

            sessionFactory.close();
        }
    }
}
