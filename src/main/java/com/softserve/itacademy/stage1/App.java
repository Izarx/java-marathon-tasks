package com.softserve.itacademy.stage1;

/**
 * Hello world!
 *
 */
public class App 
{

    public long op (int ... nums){
        return nums[0] + nums[1];
    }

    public long op (long num1, long num2) {
        return num1 - num2;
    }

    public static void main( String[] args )
    {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "Ihor Zakharko";
        emp1.salary = 1000.0f;

        emp2.fullName = "Test Test";
        emp2.salary = 900.0f;

        Employee[] employees = {emp1, emp2};

        String employeesInfo = "[";

        for (Employee e: employees) {
            employeesInfo += String.format("{fullName: \"%s\", salary: %.1f}, ", e.fullName, e.salary);
        }

        employeesInfo = employeesInfo.substring(0, employeesInfo.length()-2) + "]";

        Product p1 = new Product();
        Product p2 = new Product("s", 10.0);
        Product p3 = new Product("d", 20.4);
        Product p4 = new Product();

        System.out.println(Product.count());

        App app = new App();
        long res = app.op(5,3);
        System.out.println(res);
    }
}
