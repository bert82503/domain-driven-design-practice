package org.ddd.payment.system.domain;

import java.util.Objects;

import org.ddd.payment.system.BaseEvent;
import org.ddd.payment.system.BaseStatus;

/**
 * 状态事件对，指定的状态只能接受指定的事件
 *
 * @since 2024/5/6
 */
public class StatusEventPair<S extends BaseStatus, E extends BaseEvent> {
    /**
     * 指定的状态
     */
    private final S status;
    /**
     * 可接受的事件
     */
    private final E event;

    public StatusEventPair(S status, E event) {
        this.status = status;
        this.event = event;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusEventPair)) {
            return false;
        }
        StatusEventPair<?, ?> other = (StatusEventPair<?, ?>) obj;
        return this.status.equals(other.status) && this.event.equals(other.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, event);
    }
}
