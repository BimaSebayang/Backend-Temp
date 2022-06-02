package id.co.backend.presentase.composite.example1;

public class SwiftDepartment implements Department{


    @Override
    public String departmentName() {
        return "Swift Department";
    }

    @Override
    public Integer countPersonal() {
        return 11;
    }
}
