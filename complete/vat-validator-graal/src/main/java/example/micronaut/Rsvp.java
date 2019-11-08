package example.micronaut;

import java.io.Serializable;

public class Rsvp implements Serializable {
    private Member member;

    public Rsvp() {}

    public Rsvp(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
