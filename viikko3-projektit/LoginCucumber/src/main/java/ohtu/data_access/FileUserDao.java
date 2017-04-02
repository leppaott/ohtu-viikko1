package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import ohtu.domain.User;

public class FileUserDao implements UserDao {

    private String file;
    private Map<String, User> users;

    public FileUserDao(String file) throws FileNotFoundException {
        this.file = file;
        users = new HashMap<>();
        readFile();
    }

    private void readFile() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file)); //username password\n
        while (reader.hasNextLine()) {
            String line[] = reader.nextLine().split(" ");
            users.put(line[0], new User(line[0], line[1]));
        }
    }

    @Override
    public List<User> listAll() {
        return users.values().stream().collect(Collectors.toList());
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }

    @Override
    public void add(User user) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(user.getUsername() + " " + user.getPassword());
        } catch (FileNotFoundException ex) {}
        try {
            readFile();
        } catch (FileNotFoundException ex) {}
    }

}
