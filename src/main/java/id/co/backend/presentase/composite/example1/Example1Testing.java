package id.co.backend.presentase.composite.example1;

import id.co.backend.presentase.bridge.example1.Blue;
import id.co.backend.presentase.bridge.example1.ShapeHex;
import id.co.backend.presentase.bridge.example1.ShapeRgb;

public class Example1Testing {

    public static void main (String[] args){
        AngularDepartment angularDepartment = new AngularDepartment();
        JavaDepartment javaDepartment = new JavaDepartment();
        SwiftDepartment swiftDepartment = new SwiftDepartment();
        HeadProgrammerDepartment headProgrammerDepartment = new HeadProgrammerDepartment();
        headProgrammerDepartment.addDepartments(angularDepartment);
        headProgrammerDepartment.addDepartments(javaDepartment);
        headProgrammerDepartment.addDepartments(swiftDepartment);
        System.out.println("count department : " + headProgrammerDepartment.countDepartment());
        System.out.println("count all personally : " + headProgrammerDepartment.countPersonaly());
        headProgrammerDepartment.removeDepartments(swiftDepartment);
        System.out.println("count all personally after remove swift department :  " + headProgrammerDepartment.countPersonaly());
    }
}
