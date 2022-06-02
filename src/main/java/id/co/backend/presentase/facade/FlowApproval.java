package id.co.backend.presentase.facade;

public class FlowApproval {
    public String SUPERVISOR = "SUPERVISOR";
    public String APPRAISER = "APPRAISER";
    public String VERIFICATOR = "VERIFICATOR";
    public String REVIEWER = "REVIEWER";


    private void approveToSupervisor(String role){
        if(role.equalsIgnoreCase(SUPERVISOR)){
            System.out.println("is approve by supervisor");
        }
    }

    private void approveToAppraiser(String role){
        if(role.equalsIgnoreCase(APPRAISER)){
            System.out.println("is approve by appraiser");
        }
    }

    private void approveToVerificator(String role){
        if(role.equalsIgnoreCase(VERIFICATOR)){
            System.out.println("is approve by verificator");
        }
    }

    private void approveToReviewer(String role){
        if(role.equalsIgnoreCase(REVIEWER)){
            System.out.println("is approve by reviewer");
        }
    }

    public void approvalFlowFacade(String role){
        approveToVerificator(role);
        approveToAppraiser(role);
        approveToReviewer(role);
        approveToSupervisor(role);
    }

    public void approvalFlowNatural(String role){
        if(role.equalsIgnoreCase(SUPERVISOR)){
            System.out.println("is approve by supervisor");
        }

        else if(role.equalsIgnoreCase(APPRAISER)){
            System.out.println("is approve by appraiser");
        }

        else if(role.equalsIgnoreCase(VERIFICATOR)){
            System.out.println("is approve by verificator");
        }

        else if(role.equalsIgnoreCase(REVIEWER)){
            System.out.println("is approve by reviewer");
        }
    }

}
