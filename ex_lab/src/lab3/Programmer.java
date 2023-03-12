package lab3;

import java.util.Date;

class Programmer extends Person {
    private String progLang;

    public Programmer(String name, String birthDate, String progLang) {
        super(name, birthDate);
        this.progLang = progLang;
    }

    public String getProgLang() {
        return progLang;
    }

    public void setProgLang(String progLang) {
        this.progLang = progLang;
    }

    @Override
    public String toString() {
        return "[Programmer] " +
                "name='" + getName() + "\' " +
                "birthDate='" + getBirthDate() + "\' " +
                "progLang='" + progLang + "\' ";
    }
}
