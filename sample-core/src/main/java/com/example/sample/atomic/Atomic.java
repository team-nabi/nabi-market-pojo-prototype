package com.example.sample.atomic;

public interface Atomic {
    <T> T withTransaction(Func<T> func);

    void withTransaction(VoidFunc voidFunc);

    <T> T withTransactionReadOnly(Func<T> func);

    interface Func<T> {
        T invoke();
    }

    interface VoidFunc {
        void invoke();
    }
}
