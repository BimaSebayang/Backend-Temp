package id.co.backend.presentase.composite.example1;

public class AngularDepartment implements Department{


    @Override
    public String departmentName() {
        return "Angular Department";
    }

    @Override
    public Integer countPersonal() {
        return 12;
    }
}
