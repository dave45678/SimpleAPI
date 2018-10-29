package me.afua.simpleapi;

public class DataClass {
    private long id;
    private String data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataClass{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }


}
