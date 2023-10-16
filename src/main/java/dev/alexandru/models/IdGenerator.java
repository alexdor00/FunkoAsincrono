package dev.alexandru.models;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong counter = new AtomicLong(0);

    public Long generateId() {
        return counter.incrementAndGet();
    }
}
