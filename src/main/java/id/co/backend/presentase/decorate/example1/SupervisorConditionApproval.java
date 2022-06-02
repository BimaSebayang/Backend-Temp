package id.co.backend.presentase.decorate.example1;

import lombok.Setter;

@Setter
public class SupervisorConditionApproval extends SupervisorApproval {

    private String conditionStatement;

    @Override
    public String approve() {
        return super.approve() + ", but with condition : " + conditionStatement;
    }

}
