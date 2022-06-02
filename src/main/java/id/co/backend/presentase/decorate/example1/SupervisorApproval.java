package id.co.backend.presentase.decorate.example1;

public class SupervisorApproval extends Approval {

    @Override
    public String approve() {
        return super.approve() + ", but from supervisor";
    }

}
