/*
 * This file is part of Spoutcraft API (http://wiki.getspout.org/).
 * 
 * Spoutcraft API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Spoutcraft API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spoutcraft.spoutcraftapi.event;

/**
 * @author lahwran
 * @param <TEvent> Event class
 */
public abstract class Event<TEvent extends Event<TEvent>> {

	/**
	 * Stores cancelled status. will be false unless a subclass publishes setCancelled.
	 */
	protected boolean cancelled = false;

	/**
	 * Get the static handler list of this event subclass.
	 * 
	 * @return HandlerList to call event with
	 */
	public abstract HandlerList<TEvent> getHandlers();

	/**
	 * Get event type name.
	 * 
	 * @return event name
	 */
	protected abstract String getEventName();

	public String toString() {
		return getEventName() + " (" + this.getClass().getName() + ")";
	}

	/**
	 * Set cancelled status. Events which wish to be cancellable should implement Cancellable and implement setCancelled as:
	 * 
	 * <pre>
	 * public void setCancelled(boolean cancelled) {
	 * 	super.setCancelled(cancelled);
	 * }
	 * </pre>
	 * 
	 * @param cancelled True to cancel event
	 */
	protected void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	/**
	 * Returning true will prevent calling any even Order slots.
	 * 
	 * @see Order
	 * @return false if the event is propogating; events which do not implement Cancellable should never return true here
	 */
	public boolean isCancelled() {
		return cancelled;
	}
}
