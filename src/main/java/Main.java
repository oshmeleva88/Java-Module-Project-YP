import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int carNum = i+1;
            car = addCarbyNumber(carNum, scanner);
            race.identifyLeader(car.name, car.speed);
        }
        System.out.print("Самая быстрая машина: " + race.leader);
        scanner.close();
    }
    public static Car addCarbyNumber(int carNumber, Scanner scanner){
        Car car = new Car();
        String name = "";
        int speed;
        while (true) {
            System.out.println(" - Введите название машины № " + carNumber + ":");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Название машины не введено!");
            } else {
                car.name = name;
                break;
            }
        }
        while (true) {
            System.out.println(" - Введите скорость машины № " + carNumber + ":");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: значение скорости не введено!");
            } else {
                try {
                    speed = Integer.parseInt(input); //как парсить тоже спросила в Яндексе
                    if (speed > 0 && speed <= 250) {
                        car.speed = speed;
                        break;
                    } else {
                        System.out.println("Ошибка! Значение скорости должно быть больше 0 и меньше 250.");
                    }
                }
                catch(NumberFormatException e) {
                    System.out.println("Ошибка! Введите целое число от 1 до 250!");
                }
            }
        }
        return car;
    }
}

