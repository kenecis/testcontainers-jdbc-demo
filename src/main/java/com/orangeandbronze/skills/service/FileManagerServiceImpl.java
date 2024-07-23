package com.orangeandbronze.skills.service;

import com.orangeandbronze.skills.domain.BinaryFile;
import com.orangeandbronze.skills.domain.TestBinaryFileRepository;
import java.util.Optional;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileManagerServiceImpl implements FileManagerService {

    @Autowired
    private TestBinaryFileRepository testBinaryFileRepository;

    @Override
    public byte[] retrieveFile(String fileId) {
        Validate.notEmpty(fileId, "Uploaded file id must not be null or empty");

        Optional<BinaryFile> binaryFileOptional = testBinaryFileRepository.findById(fileId);

        if(binaryFileOptional.isPresent()) {

            BinaryFile paymentGatewayFile = binaryFileOptional.get();
            return  ArrayUtils.toPrimitive(paymentGatewayFile.getImage());
        }

        return new byte[0];
    }
}
