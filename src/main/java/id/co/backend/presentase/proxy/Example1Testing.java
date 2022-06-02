package id.co.backend.presentase.proxy;

public class Example1Testing {

    public static void main (String[] args){
        Approval approval = new ApprovalProxy(1);
        approval.approval();
        approval = new ApprovalProxy(2);
        approval.approval();
        approval = new ApprovalProxy(3);
        approval.approval();
    }
}
