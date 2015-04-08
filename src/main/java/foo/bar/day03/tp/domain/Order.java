package foo.bar.day03.tp.domain;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public class Order extends BaseEntity {

    private Event event;
    private Guest guest;
    private Long regDate;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }
}
