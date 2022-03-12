package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите x-координату первой точки: ");
        double point_first_x = scan.nextDouble();
        System.out.print("Введите y-координату первой точки: ");
        double point_first_y = scan.nextDouble();

        System.out.print("Введите x-координату второй точки: ");
        double point_second_x = scan.nextDouble();
        System.out.print("Введите y-координату второй точки: ");
        double point_second_y = scan.nextDouble();

        System.out.print("Введите x-координату третьей точки: ");
        double point_third_x = scan.nextDouble();
        System.out.print("Введите y-координату третьей точки: ");
        double point_third_y = scan.nextDouble();

        double per = perimeter(point_first_x, point_first_y, point_second_x, point_second_y, point_third_x, point_third_y);

        if (per <= 0) {
            System.out.println("Треугольника не существует!");
        } else {
            System.out.println("\nПериметр треугольника: " + per);
            double a = area(point_first_x, point_first_y, point_second_x, point_second_y, point_third_x, point_third_y);
            System.out.println("Площадь треугольника: " + a);
            boolean p = point(point_first_x, point_first_y, point_second_x, point_second_y, point_third_x, point_third_y);
            if (p) {
                System.out.println("Точка находится внутри треугольника!");
            } else {
                System.out.println("Точка находится снаружи треугольника!");
            }
        }
    }

    public static double perimeter(double point_first_x, double point_first_y, double point_second_x, double point_second_y, double point_third_x, double point_third_y) {

        double f_s = 0;
        double s_t = 0;
        double t_f = 0;

        if (point_first_x == point_second_x && point_first_y != point_second_y) { //расстояние между первой и второй точками
            f_s = point_first_y - point_second_y;
            if (f_s < 0) {
                f_s = f_s * (-1);
            }
        } else if (point_first_y == point_second_y && point_first_x != point_second_x) {
            f_s = point_first_x - point_second_x;
            if (f_s < 0) {
                f_s = f_s * (-1);
            }
        } else if (point_first_y != point_second_y && point_first_x != point_second_x) {
            double fx_sx = point_first_x - point_second_x;
            if (fx_sx < 0) {
                fx_sx = fx_sx * (-1);
            }
            double fy_sy = point_first_y - point_second_y;
            if (fy_sy < 0) {
                fy_sy = fy_sy * (-1);
            }
            f_s = Math.pow(fx_sx, 2) + Math.pow(fy_sy, 2);
        }

        if (point_second_x == point_third_x && point_second_y != point_third_y) { //расстояние между второй и третьей точками
            s_t = point_second_y - point_third_y;
            if (s_t < 0) {
                s_t = s_t * (-1);
            }
        } else if (point_second_y == point_third_y && point_second_x != point_third_x) {
            s_t = point_second_x - point_third_x;
            if (s_t < 0) {
                s_t = s_t * (-1);
            }
        } else if (point_second_y != point_third_y && point_second_x != point_third_x) {
            double sx_tx = point_second_x - point_third_x;
            if (sx_tx < 0) {
                sx_tx = sx_tx * (-1);
            }
            double sy_ty = point_second_y - point_third_y;
            if (sy_ty < 0) {
                sy_ty = sy_ty * (-1);
            }
            s_t = Math.pow(sx_tx, 2) + Math.pow(sy_ty, 2);
        }

        if (point_third_x == point_first_x && point_third_y != point_first_y) { //расстояние между третьей и первой точками
            t_f = point_third_y - point_first_y;
            if (t_f < 0) {
                t_f = t_f * (-1);
            }
        } else if (point_third_y == point_first_y && point_third_x != point_first_x) {
            t_f = point_third_x - point_first_x;
            if (t_f < 0) {
                t_f = t_f * (-1);
            }
        } else if (point_third_y != point_first_y && point_third_x != point_first_x) {
            double tx_fx = point_third_x - point_first_x;
            if (tx_fx < 0) {
                tx_fx = tx_fx * (-1);
            }
            double ty_fy = point_first_y - point_second_y;
            if (ty_fy < 0) {
                ty_fy = ty_fy * (-1);
            }
            t_f = Math.pow(tx_fx, 2) + Math.pow(ty_fy, 2);
        }
        return (f_s + s_t + t_f);
    }

    public static double area(double point_first_x, double point_first_y, double point_second_x, double point_second_y, double point_third_x, double point_third_y) {
        double s = ((((point_first_x-point_third_x)*(point_first_y-point_third_y))-((point_second_x-point_third_x)*(point_second_y-point_third_x))));
        return (0.5*s);
    }

    public static Boolean point (double point_first_x, double point_first_y, double point_second_x, double point_second_y, double point_third_x, double point_third_y) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nПроверка на нахождение точки внутри треугольника.\nВведите x-координату точки: ");
        double p_x = scan.nextDouble();
        System.out.print("Введите y-координату точки: ");
        double p_y = scan.nextDouble();

        double first = (point_first_x - p_x)*(point_second_y-point_first_y)-(point_second_x-point_first_x)*(point_first_y-p_y);
        double second = (point_second_x - p_x)*(point_third_y-point_second_y)-(point_third_x-point_second_x)*(point_second_y-p_y);
        double third = (point_third_x - p_x)*(point_first_y-point_third_y)-(point_first_x-point_third_x)*(point_third_y-p_y);

        if (first < 0 && second < 0 && third < 0) {
            return true;
        } else if (first > 0 && second > 0 && third > 0) {
            return true;
        } else if (first == 0 && second == 0 && third == 0) {
            return true;
        } else {
            return false;
        }
    }
}