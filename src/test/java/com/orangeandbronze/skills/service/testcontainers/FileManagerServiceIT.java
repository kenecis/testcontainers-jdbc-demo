package com.orangeandbronze.skills.service.testcontainers;

import com.orangeandbronze.skills.service.FileManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;

@ActiveProfiles({"test"})
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:data/insert-test-images.sql")
public class FileManagerServiceIT {

    @Autowired
    private FileManagerService fileManagerService;

    @Test
    public void retrieveFile_fileExist_success() {

        final String fileId = "3c26b213-9778-4e60-922a-16dae669547d";

        byte[] file = fileManagerService.retrieveFile(fileId);

        Assert.assertThat(file.length, greaterThan(0));
    }
}
