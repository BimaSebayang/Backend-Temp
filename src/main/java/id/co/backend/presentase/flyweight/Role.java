package id.co.backend.presentase.flyweight;

import lombok.Builder;

@Builder
public class Role {
    private String name;
    private int personally;
    private String headName;


    public String recordOfRole(){
        return "name : " + name + ", personally : " + personally + " person, headName : " + headName;
    }
}
