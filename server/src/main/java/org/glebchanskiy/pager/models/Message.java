package org.glebchanskiy.pager.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shared_message")
@Getter
@Setter
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "username")
    private String userId;

    public Message(Integer id, String text, String userId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
    }

    public Message() {
    }
}
