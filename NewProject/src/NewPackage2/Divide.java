package NewPackage2;

public class Divide {
	private double num1;
    private double num2;

    public Divide(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double calculate() {
        return num1 / num2;
    }
}