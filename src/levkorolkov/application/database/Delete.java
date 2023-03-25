package levkorolkov.application.database;

public class Delete implements Command {
    private Database database;

    public Delete (Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}
