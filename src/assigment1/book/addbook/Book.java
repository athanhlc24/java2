package assigment1.book.addbook;

public class Book {
    String ID;
    String name;
    String hour;

    public Book(String ID, String name, String hour) {
        this.ID = ID;
        this.name = name;
        this.hour = hour;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return getID()+"--"+getName()+"--"+getHour();
    }
}
