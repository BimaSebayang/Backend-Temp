package id.co.backend.presentase.composite.example1;

public class JavaDepartment implements Department{


    @Override
    public String departmentName() {
        return "Java Department";
    }

    @Override
    public Integer countPersonal() {
        return 10;
    }
}
