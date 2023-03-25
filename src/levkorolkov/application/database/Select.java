package levkorolkov.application.database;

public class Select implements Command {
    private Database database;

    public Select(Database database) {
        this.database = database;
    }


    @Override
    public void execute() {
        database.select();
    }


}
