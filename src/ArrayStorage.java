import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int resumesCounter = 0;

    void clear() {
        Arrays.fill(storage, 0, resumesCounter, null);
        resumesCounter = 0;
    }

    void save(Resume r) {
        storage[resumesCounter] = r;
        resumesCounter++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < resumesCounter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < resumesCounter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[resumesCounter - 1];
                storage[resumesCounter - 1] = null;
                resumesCounter--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] trimmedResumes = new Resume[resumesCounter];
        System.arraycopy(storage, 0, trimmedResumes, 0, resumesCounter);
        return trimmedResumes;
    }

    int size() {
        return resumesCounter;
    }
}
