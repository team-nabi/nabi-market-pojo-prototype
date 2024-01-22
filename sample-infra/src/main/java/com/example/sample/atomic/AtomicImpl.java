package com.example.sample.atomic;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AtomicImpl implements Atomic {
    @Override
    @Transactional
    public <T> T withTransaction(Func<T> func) {
        return func.invoke();
    }

    @Override
    @Transactional
    public void withTransaction(VoidFunc voidFunc) {
        voidFunc.invoke();
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T withTransactionReadOnly(Func<T> func) {
        return func.invoke();
    }
}
