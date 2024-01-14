package services.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;

public interface IFileManager<T> {
    public void saveDataToFile(Deque<T> stack) throws FileNotFoundException;

    public Deque<T> loadDataFromFile(File file);
}