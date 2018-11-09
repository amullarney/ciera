package io.ciera.runtime.summit.statemachine;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import io.ciera.runtime.summit.types.Set;

public class EventSet extends Set<EventSet, IEvent> {
	
	public EventSet() {
	}

	public EventSet(Collection<IEvent> c) {
		super(c);
	}

	@Override
	public IEvent nullElement() {
		return null;
	}

	@Override
	public EventSet emptySet() {
		return new EventSet();
	}

	@Override
	public List<IEvent> elements() {
        return Arrays.asList(toArray(new IEvent[0]));
	}

	@Override
	public EventSet value() {
		return this;
	}

}
