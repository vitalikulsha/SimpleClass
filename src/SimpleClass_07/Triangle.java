package SimpleClass_07;

/*
7. Описать класс, представляющий треугольник.
Предусмотреть методы для создания объектов, вычисления площади,
периметра и точки пересечения медиан.
 */

import static java.lang.Math.*;

public class Triangle {
    int sideA;
    int sideB;
    int sideC;

    public Triangle() {
    }

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle createTriangle() {
        //создание и проверка существования треугольник с заданными сторонами
        boolean result = true;
        while (result) {
            sideA = (int) (random() * 100) + 1;
            sideB = (int) (random() * 100) + 1;
            sideC = (int) (random() * 100) + 1;
            if ((sideA + sideB) > sideC && (sideA + sideC) > sideB && (sideB + sideC) > sideA) {
                result = false;
            } else {
                result = true;
            }
        }
        return new Triangle(sideA, sideB, sideC);
    }

    public double calculateAreaTriangle() {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public int calculatePerimeterTriangle() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Треугольник со стронами: " +
                "sideA = " + sideA +
                ", sideB = " + sideB +
                ", sideC = " + sideC +
                '.';
    }
}
