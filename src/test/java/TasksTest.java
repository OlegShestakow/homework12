import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {
    @Test
    public void shouldQueryValidProject() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Приложение НетоБанка";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryValidTopic() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Выкатка 3й версии приложения";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryInvalidProject() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Приложение РусскаяКартошка";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryInvalidTopic() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Выкатка 10й версии приложения";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryValidTitle() {
        SimpleTask task = new SimpleTask(
                30,
                "Взять больничный"
        );
        String query = "Взять больничный";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryInvalidTitle() {
        SimpleTask task = new SimpleTask(
                30,
                "Взять больничный"
        );
        String query = "Выйти на работу";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryValidSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(23, subtasks);
        String query = "Молоко";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryInvalidSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(23, subtasks);
        String query = "Яица";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}




