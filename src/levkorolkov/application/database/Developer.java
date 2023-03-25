package levkorolkov.application.database;

public class Developer {
    private final Select select;
    private final Delete delete;
    private final Insert insert;
    private final Create create;

    public Developer(Select select, Delete delete, Insert insert, Create create) {
        this.select = select;
        this.delete = delete;
        this.insert = insert;
        this.create = create;
    }

    public void selectRow() {
        select.execute();
    }

    public void deleteRow() {
        delete.execute();
    }
    public void insertRow() {
        insert.execute();
    }
    public void createRow() {
        create.execute();
    }
}
