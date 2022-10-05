package Controller;

import Model.EntryModel;

public class EntryController {
    private EntryModel entry = new EntryModel();

    public void saveEntry(){
        entry.saveEntry();
    }
}
