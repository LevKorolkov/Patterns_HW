package levkorolkov.application.database;

public class Create implements Command {
    private Database database;

    public Create(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.create();
    }
}
