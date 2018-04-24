package com.rtukpe.fixtures.utils.rx;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class RxBus implements EventBus {

    private Subject<Object> bus;

    @Inject
    public RxBus() {
        bus = PublishSubject.create().toSerialized();
    }

    @Override
    public void cleanup() {

    }

    @Override
    public void post(@NotNull Object event) {
        if (this.bus.hasObservers()) {
            this.bus.onNext(event);
        }
    }

    @NotNull
    @Override
    public <T> Observable<T> observe(@NotNull Class<T> eventClass) {
        return bus.filter(o -> o != null) // Filter out null objects, better safe than sorry
                .filter(eventClass::isInstance) // We're only interested in a specific event class
                .cast(eventClass); // Cast it for easier usage
    }
}
