package lab3;

import java.util.Date;

class Designer extends Person {
    private String usedTool;

    public Designer(String name, String birthDate, String usedTool) {
        super(name, birthDate);
        this.usedTool = usedTool;
    }

    public String getUsedTool() {
        return usedTool;
    }

    public void setUsedTool(String usedTool) {
        this.usedTool = usedTool;
    }

    @Override
    public String toString() {
        return "[Designer] " +
                "name='" + getName() + "\' " +
                "birthDate='" + getBirthDate() + "\' " +
                "usedTool='" + usedTool + "\' ";
    }

}
