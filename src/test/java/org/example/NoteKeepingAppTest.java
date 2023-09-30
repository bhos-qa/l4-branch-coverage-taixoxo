package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteKeepingAppTest {

    @Test
    void addNote() {
        NoteKeepingApp app = new NoteKeepingApp();
        assertEquals("Note added successfully.",app.addNote("first note"));
    }

    @Test
    void editNote() {
        NoteKeepingApp app = new NoteKeepingApp();
        app.addNote("first note");
        assertEquals("Note 1 updated successfully.",app.editNote(0,"edit first note"));

    }

    @Test
    void deleteNote() {
        NoteKeepingApp app = new NoteKeepingApp();
        app.addNote("first note");
        assertEquals("Note 1 deleted successfully.",app.deleteNote(0));
    }

    @Test
    void countNotes() {
        NoteKeepingApp app = new NoteKeepingApp();
        app.addNote("first note");
        app.addNote("second note");
        app.addNote("third note");
        assertEquals(3,app.countNotes());
    }

    @Test
    void clearNotes() {
        NoteKeepingApp app = new NoteKeepingApp();
        app.addNote("first note");
        app.addNote("second note");
        app.addNote("third note");
        assertEquals("All notes cleared.",app.clearNotes());
    }
}