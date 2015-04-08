package foo.bar.day03.tp.service;

import foo.bar.day03.tp.domain.Event;
import foo.bar.day03.tp.domain.Guest;
import foo.bar.day03.tp.domain.Order;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public interface OrderService {

    Order signUp(Event event, Guest guest);
}
