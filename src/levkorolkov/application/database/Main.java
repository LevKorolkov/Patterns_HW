package levkorolkov.application.database;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Developer developer = new Developer(new Select(database), new Delete(database), new Insert(database), new Create(database));

        developer.selectRow();
        developer.createRow();
        developer.deleteRow();
        developer.insertRow();
    }

}
