package marius_project.prog2.model;

public class Lists {
    public  int list_id;
    public  String list_name;

    public Lists(int list_id, String list_name) {
        this.list_id = list_id;
        this.list_name = list_name;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    @Override
    public String toString() {
        return "List{" +
                "list_id=" + list_id +
                ", list_name='" + list_name + '\'' +
                '}';
    }
}
