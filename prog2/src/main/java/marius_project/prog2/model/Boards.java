package marius_project.prog2.model;

public class Boards {
    public int id_boards;
    public String Board_name;
    public int list_id;

    public Boards(int id_boards, String board_name, int list_id, int listId) {
        this.id_boards = id_boards;
        Board_name = board_name;
        this.list_id = list_id;
    }

    public int getId_boards() {
        return id_boards;
    }

    public void setId_boards(int id_boards) {
        this.id_boards = id_boards;
    }

    public String getBoard_name() {
        return Board_name;
    }

    public void setBoard_name(String board_name) {
        Board_name = board_name;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    @Override
    public String toString() {
        return "Boards{" +
                "id_boards=" + id_boards +
                ", Board_name='" + Board_name + '\'' +
                ", list_id=" + list_id +
                '}';
    }
}
