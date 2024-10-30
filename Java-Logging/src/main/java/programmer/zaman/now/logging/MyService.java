package programmer.zaman.now.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    private MyRepository repo;

    public MyService(MyRepository repo) {
        this.repo = repo;
    }

    public void save() {
        log.info("Serivce Save");
        this.repo.save();
    }
}
