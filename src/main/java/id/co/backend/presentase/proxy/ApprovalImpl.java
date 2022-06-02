package id.co.backend.presentase.proxy;

public class ApprovalImpl implements Approval {
    private int tingkat;
    public ApprovalImpl(int tingkat){
        this.tingkat = tingkat;
    }

    @Override
    public void approval() {
        System.out.println("sekarang ada di approval tingkat : " + this.tingkat);
    }
}
