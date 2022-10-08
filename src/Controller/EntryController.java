package Controller;

import Model.EntryModel;

public class EntryController {
    private EntryModel entry = new EntryModel();
    private Controllers controllers;

    public EntryController(Controllers controllers){
        this.controllers = controllers;
    }

    public Object[] getEntryDates(){
        return entry.getUserEntryDates(controllers.userController.getCurrentUserId());
    }

    public void addBlankEntry(){
        int userId = controllers.userController.getCurrentUserId();
        entry.addBlankEntry(userId);
    }
}
