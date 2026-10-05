public class Car {
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