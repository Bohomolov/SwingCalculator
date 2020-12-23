package blogic;

import utils.Constants;

public class Calculations {
    public double multiply(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    public double divinity(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException(Constants.ILLEGAL_ARGUMENT);
        }
        return firstNum / secondNum;
    }

    public double minus(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    public double sum(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    public double modulo(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException(Constants.ILLEGAL_ARGUMENT);
        }
        return firstNum % secondNum;

    }
}
