package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "command_context", schema = "ag")
public class CommandContextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.command_context_id_seq")
    @SequenceGenerator(name = "ag.command_context_id_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "command_id")
    private CommandEntity commandEntity;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
}
