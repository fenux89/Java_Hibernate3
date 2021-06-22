package homework4;



import homework4.dao.CarService;
import homework4.dao.ClientService;
import homework4.entity.Car;
import homework4.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        CarService carService = new CarService();

        Client client = new Client("Lexa", 11, "(978)5876451");
        Client client2 = new Client("Max", 23, "(978)5876478");
        Car car = new Car("BMV", "X5", 100000);
        Car car2 = new Car("BMV", "X3", 200000);

        carService.add(car);
        clientService.addClient(client);

        carService.updateCar(1, car2);
        clientService.updateClient(1, client2);

        System.out.println(carService.getById(1));
        System.out.println(clientService.getClient(1));

        carService.removeCar(2);
        clientService.removeClient(2);

        List<Car> cars = carService.getAll();
        List<Client> clients = clientService.getAllClients();


        for (Car car1 : cars) {
            System.out.println(car1);
        }

        for (Client client1 : clients) {
            System.out.println(client1);
        }

        SessionFactory sf = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        List<Object[]> list = session.createQuery("select model, price from Car").list();

        for(Object[] arr: list) {
            System.out.println(Arrays.toString(arr));
        }
        sf.close();

    }

}
