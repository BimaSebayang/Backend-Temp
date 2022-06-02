package id.co.backend.presentase.flyweight;

public class Example1Testing {

    public static void main (String[] args){
      recordOfApproval();
      recordOfApprovalOnlySupervisor();
    }
    public static void recordOfApproval(){
        Role role = RoleDao.getRole("supervisor");
        System.out.println(role.recordOfRole());
        Role role2 = RoleDao.getRole("appraiser");
        System.out.println(role2.recordOfRole());
    }
    public static void recordOfApprovalOnlySupervisor(){
        Role role3 = RoleDao.getRole("supervisor");
        System.out.println(role3.recordOfRole());
    }
}
