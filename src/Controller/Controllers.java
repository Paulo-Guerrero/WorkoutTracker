package Controller;

public class Controllers {
    public UserController userController = new UserController(this);
    public EntryController entryController = new EntryController(this);
    public LiftController liftController = new LiftController(this);
}
