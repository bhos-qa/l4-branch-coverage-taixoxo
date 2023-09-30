package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteKeepingApp {
    private List<String> notes;

    public NoteKeepingApp() {
        notes = new ArrayList<>();
    }

    // Method to add a new note
    public String addNote(String note) {
        notes.add(note);
        return "Note added successfully.";
    }

    // Method to view all notes
    public void viewAllNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("Your Notes:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    // Method to view a specific note by index
    public void viewNote(int noteIndex) {
        if (isValidNoteIndex(noteIndex)) {
            String note = notes.get(noteIndex);
            System.out.println("Note " + (noteIndex + 1) + ": " + note);
        } else {
            System.out.println("Invalid note index.");
        }
    }

    // Method to edit a specific note by index
    public String editNote(int noteIndex, String updatedNote) {
        if (isValidNoteIndex(noteIndex)) {
            notes.set(noteIndex, updatedNote);
            return "Note " + (noteIndex + 1) + " updated successfully.";
        } else {
            return "Invalid note index.";
        }
    }

    // Method to delete a specific note by index
    public String deleteNote(int noteIndex) {
        if (isValidNoteIndex(noteIndex)) {
            notes.remove(noteIndex);
            return "Note " + (noteIndex + 1) + " deleted successfully.";
        } else {
            return "Invalid note index.";
        }
    }

    // Method to count the number of notes
    public int countNotes() {
        return notes.size();
    }

    // Method to clear all notes
    public String clearNotes() {
        notes.clear();
        return "All notes cleared.";
    }

    // Method to search notes by keyword
    public List<String> searchNotes(String keyword) {
        List<String> matchingNotes = new ArrayList<>();
        for (String note : notes) {
            if (note.contains(keyword)) {
                matchingNotes.add(note);
            }
        }
        return matchingNotes;
    }

    // Method to check if a note index is valid
    private boolean isValidNoteIndex(int noteIndex) {
        return noteIndex >= 0 && noteIndex < notes.size();
    }

    // Main method to run the application
    public static void main(String[] args) {
        NoteKeepingApp app = new NoteKeepingApp();

        // Adding notes
        app.addNote("Note 1: This is the first note.");
        app.addNote("Note 2: This is the second note.");
        app.addNote("Note 3: This is the third note.");

        // Viewing all notes
        app.viewAllNotes();

        // Viewing a specific note
        app.viewNote(1);

        // Editing a note
        app.editNote(1, "Updated Note 1: This is the updated note.");

        // Deleting a note
        app.deleteNote(2);

        // Counting notes
        int noteCount = app.countNotes();
        System.out.println("Total number of notes: " + noteCount);

        // Clearing all notes
        app.clearNotes();
        File tempDir;

        try {
            tempDir = File.createTempFile("log_book_borrow", null);
        } catch ( IOException ex) {
            throw new RuntimeException(ex);
        }

        tempDir.delete();
        tempDir.mkdir();

        // Searching for notes
        List<String> matchingNotes = app.searchNotes("updated");
        System.out.println("Matching Notes:");
        for (String note : matchingNotes) {
            System.out.println(note);
        }
    }
}
