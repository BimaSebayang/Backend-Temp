package id.co.backend.presentase.composite.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeadProgrammerDepartment implements Department{

    private List<Department> childDepartments = new ArrayList<>();

    @Override
    public String departmentName() {
        return "Angular Department";
    }

    @Override
    public Integer countPersonal() {
        return 12;
    }

    public void addDepartments(Department department){
        childDepartments.add(department);
    }

    public void removeDepartments(Department department){
        childDepartments.remove(department);
    }

    public Integer countDepartment(){
       return childDepartments.size();
    }

    public Integer countPersonaly(){
        return childDepartments.stream().collect(Collectors.summingInt(Department::countPersonal));
    }
}
