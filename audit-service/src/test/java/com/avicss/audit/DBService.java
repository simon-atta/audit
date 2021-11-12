package com.avicss.audit;

import org.junit.ClassRule;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.DockerComposeContainer;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
public class DBService {

    @ClassRule
    public static DockerComposeContainer compose =
            new DockerComposeContainer(new File("src/test/resources/docker-compose-test.yml"));

    @ClassRule
    public static DockerComposeContainer composeMysql =
            new DockerComposeContainer(new File("src/test/resources/mysql-compose-test.yml"));

    @PostConstruct
    private void init() {
        compose.start();
        composeMysql.start();
    }
}
