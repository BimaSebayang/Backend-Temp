package id.co.backend.presentase.facade;

import id.co.backend.presentase.decorate.example1.Approval;
import id.co.backend.presentase.decorate.example1.SupervisorApproval;
import id.co.backend.presentase.decorate.example1.SupervisorConditionApproval;

public class Example1Testing {

    public static void main (String[] args){
        FlowApproval approval = new FlowApproval();
        System.out.println("facade : ");
        approval.approvalFlowFacade(approval.APPRAISER);
        System.out.println("tanpa facade : ");
        approval.approvalFlowNatural(approval.APPRAISER);
    }
}
