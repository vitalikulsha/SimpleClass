package SimpleClass_07;

/*
7. Описать класс, представляющий треугольник.
Предусмотреть методы для создания объектов, вычисления площади,
периметра и точки пересечения медиан.
 */

import java.util.Arrays;

public class Simple_07 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle().createTriangle();
        System.out.println(triangle.toString());
        System.out.printf("Площадь заданного треугольника равна %.2f.", triangle.calculateAreaTriangle());
        System.out.println("\nПериметр заданного треугольника равен " + triangle.calculatePerimeterTriangle() +".");
        System.out.printf("Координаты точки пересечения медиан треугольника: X = %.2f, Y = %.2f.",
                triangle.calculateCoordinatePointMeridian()[0], triangle.calculateCoordinatePointMeridian()[1]);
    }
}
