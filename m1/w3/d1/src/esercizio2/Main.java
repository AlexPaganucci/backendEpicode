package esercizio2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		DB db = new DB();
		db.connect();
		db.insertStudent("Mario", "Rossi", "m", LocalDate.of(1996,12,05), 6.5, 6, 7);
		db.deleteStudent(6);
		db.updateStudents(4, "Giulia", "Gialli");
	}

}
