package levkorolkov.application.database;

public class Insert implements Command {
    private Database database;

    public Insert(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}
