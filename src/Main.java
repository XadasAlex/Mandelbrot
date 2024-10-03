public class Main {
    public static void main(String[] args) {
        Mandelbrot mb = new Mandelbrot(10000, -0.95, 0, 3.5, 3);
        new MyFrame(mb);
    }
}