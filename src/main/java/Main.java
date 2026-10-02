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
                //тут я поискала, как можно проверить, есть ли в строке символы кроме цифр.
                //Пробовала Scanner.hasNextInt() использовать, но все время какая-то ерунда получалась
                //на пустой ввод плохо реагировал.
                if (!input.matches("-?\\d+")) {
                    System.out.println("Ошибка! Введите целое число!");
                }
                else {
                    speed = Integer.parseInt(input); //как парсить тоже спросила в Яндексе
                    if (speed > 0 && speed <= 250) {
                        car.speed = speed;
                        break;
                    }
                    else {
                        System.out.println("Ошибка! Значение скорости должно быть больше 0 и меньше 250.");
                    }
                }
            }


        }

        return car;
    }
    public static class Car {
        String name; //название автомобиля
        int speed;
        //конструктор
        public Car() {
            this.name = "";
            this.speed = 0;
        }
         public Car (String name, int speed){
            this.name = name;
            this.speed = speed;
        }


    }
    public static class Race {
        String leader = "";
        int distance = 0;
        public Race() {
            this.leader = "";
            this.distance = 0;
        }
        public Race(String name, int distance) {
            this.leader = name;
            this.distance = distance;
        }

        void identifyLeader(String newName, int newSpeed) {
            int newDistance = newSpeed * 24;
            if (newDistance > distance) {
                leader = newName;
                distance = newDistance;
            }
        }
    }
}

