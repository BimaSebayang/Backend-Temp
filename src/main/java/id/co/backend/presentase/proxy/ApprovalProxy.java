package id.co.backend.presentase.proxy;

import java.util.Objects;

public class ApprovalProxy implements Approval{
    private int tingkat;
    private ApprovalImpl approvalImpl;
    public ApprovalProxy(int tingkat){
        this.tingkat = tingkat;
    }

    @Override
    public void approval() {
        if(tingkat<3){
            approvalImpl = new ApprovalImpl(this.tingkat);
            approvalImpl.approval();
        }
        else{
            System.out.println("tingkatan approval hanya sampai 2");
        }
    }
}
