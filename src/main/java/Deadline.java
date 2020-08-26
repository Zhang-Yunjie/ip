import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDate by;

    public Deadline(String description, String by) {
        super(description);
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.by = LocalDate.parse(by,inputFormat);
    }


    @Override
    public String toString() {
        String byTime = by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return super.toString() + "(by:" + byTime + ")";
    }
}