package jzxy.cbq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: cbq1024
 * @description: AbstractTestcontainersTest
 * @since 2024/6/23 16:06
 */
@Testcontainers
public class AbstractTestcontainersTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer
            = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.2"));

    @Test
    void canEstablishedConnection() {
        assertThat(postgreSQLContainer.isCreated()).isTrue();
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }
}
