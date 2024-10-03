public class Mandelbrot {
    public int maxIter;
    private double middleR;
    private double middleI;
    private double rangeR;
    private double rangeI;
    Mandelbrot(int maxIter, double middleR, double middleI, double rangeR, double rangeI) {
        this.maxIter = maxIter;
        this.middleR = middleR;
        this.middleI = middleI;
        this.rangeR = rangeR;
        this.rangeI = rangeI;
    }

    double getCReal(double xPercent) {
        return xPercent * rangeR + middleR - rangeR / 2;
    }

    double getCImaginary(double yPercent) {
        return yPercent * rangeI + middleI - rangeI / 2;
    }
}