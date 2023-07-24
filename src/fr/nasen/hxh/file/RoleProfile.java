package fr.nasen.hxh.file;

public class RoleProfile {

    private String role;
    private String nen;

    public RoleProfile(String role,String nen){
        this.role = role;
        this.nen = nen;
    }

    public String getRole() {
        return role;
    }

    public String getNen(){
        return nen;
    }
        public static RoleProfile createProfile(String role, String nen ){
            return new RoleProfile(role, nen);
        }


}
