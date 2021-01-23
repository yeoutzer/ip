package tasks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {
    protected LocalDate date;
    protected LocalTime time;

    public DeadlineTask(String description, LocalDate date) {
        super(description, 'D');
        this.date = date;
        this.time = null;
    }

    public DeadlineTask(String description, LocalDate date, LocalTime time) {
        super(description, 'D');
        this.date = date;
        this.time = time;
    }

    public String getDateSaveString() {
        return this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getTimeSaveString() {
        return this.time == null
        ? ""
        : " | " + this.time.format(DateTimeFormatter.ofPattern("HHmm"));
    }

    @Override
    public String getSaveString() {
        return super.getSaveString() + " | " + getDateSaveString() + getTimeSaveString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + this.date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
                + (this.time == null
                ? ""
                : " " + this.time.format(DateTimeFormatter.ofPattern("hh:mm a")))
                + ")";
    }
}