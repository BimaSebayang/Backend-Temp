package id.co.backend.presentase.decorate.example1;

import id.co.backend.presentase.composite.example1.AngularDepartment;
import id.co.backend.presentase.composite.example1.HeadProgrammerDepartment;
import id.co.backend.presentase.composite.example1.JavaDepartment;
import id.co.backend.presentase.composite.example1.SwiftDepartment;

public class Example1Testing {

    public static void main (String[] args){
        Approval approval = new Approval();
        System.out.println(approval.approve());
        SupervisorApproval supervisorApproval = new SupervisorApproval();
        System.out.println(supervisorApproval.approve());
        SupervisorConditionApproval supervisorConditionApproval = new SupervisorConditionApproval();
        supervisorConditionApproval.setConditionStatement("Need To Approve 2nd");
        System.out.println(supervisorConditionApproval.approve());
    }
}
