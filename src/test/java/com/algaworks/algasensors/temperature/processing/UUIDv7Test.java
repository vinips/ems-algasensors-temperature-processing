package com.algaworks.algasensors.temperature.processing;

import com.algaworks.algasensors.temperature.processing.common.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7() {
        UUID uuid1 = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();

        System.out.println(uuid1);
        System.out.println(uuid2);
        System.out.println(uuid3);
        System.out.println(uuid4);

        Assertions.assertNotEquals(uuid1, uuid2);
    }
}
