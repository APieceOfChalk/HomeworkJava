public class Box extends Shape{

    public Box(double volume) {
        super(volume);
    }

    public boolean add(Shape shape) {
        if (shape.getVolume() <= this.getVolume()) {
            this.setVolume(this.getVolume()-shape.getVolume());
            System.out.println("Успешно добавлен новый объект!");
            return true;
        }
        else {
            System.out.println("Нет свободного места!");
            return false;
        }
    }

}