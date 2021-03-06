package com.giga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    @Range(min = 10000, max = 99999)
    private Integer code;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    public Code(Integer code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Code(Integer code, Book book, Status status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }
}
