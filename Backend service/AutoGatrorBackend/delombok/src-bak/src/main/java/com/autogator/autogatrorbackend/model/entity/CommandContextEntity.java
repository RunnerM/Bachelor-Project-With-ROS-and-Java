package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

@Entity
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


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class CommandContextEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private CommandEntity commandEntity;
        @SuppressWarnings("all")
        private String key;
        @SuppressWarnings("all")
        private String value;

        @SuppressWarnings("all")
        CommandContextEntityBuilder() {
        }

        @SuppressWarnings("all")
        public CommandContextEntity.CommandContextEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextEntity.CommandContextEntityBuilder commandEntity(final CommandEntity commandEntity) {
            this.commandEntity = commandEntity;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextEntity.CommandContextEntityBuilder key(final String key) {
            this.key = key;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextEntity.CommandContextEntityBuilder value(final String value) {
            this.value = value;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextEntity build() {
            return new CommandContextEntity(this.id, this.commandEntity, this.key, this.value);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "CommandContextEntity.CommandContextEntityBuilder(id=" + this.id + ", commandEntity=" + this.commandEntity + ", key=" + this.key + ", value=" + this.value + ")";
        }
    }

    @SuppressWarnings("all")
    public static CommandContextEntity.CommandContextEntityBuilder builder() {
        return new CommandContextEntity.CommandContextEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public CommandEntity getCommandEntity() {
        return this.commandEntity;
    }

    @SuppressWarnings("all")
    public String getKey() {
        return this.key;
    }

    @SuppressWarnings("all")
    public String getValue() {
        return this.value;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setCommandEntity(final CommandEntity commandEntity) {
        this.commandEntity = commandEntity;
    }

    @SuppressWarnings("all")
    public void setKey(final String key) {
        this.key = key;
    }

    @SuppressWarnings("all")
    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommandContextEntity)) return false;
        final CommandContextEntity other = (CommandContextEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$commandEntity = this.getCommandEntity();
        final Object other$commandEntity = other.getCommandEntity();
        if (this$commandEntity == null ? other$commandEntity != null : !this$commandEntity.equals(other$commandEntity)) return false;
        final Object this$key = this.getKey();
        final Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof CommandContextEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $commandEntity = this.getCommandEntity();
        result = result * PRIME + ($commandEntity == null ? 43 : $commandEntity.hashCode());
        final Object $key = this.getKey();
        result = result * PRIME + ($key == null ? 43 : $key.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "CommandContextEntity(id=" + this.getId() + ", commandEntity=" + this.getCommandEntity() + ", key=" + this.getKey() + ", value=" + this.getValue() + ")";
    }

    @SuppressWarnings("all")
    public CommandContextEntity() {
    }

    @SuppressWarnings("all")
    public CommandContextEntity(final Long id, final CommandEntity commandEntity, final String key, final String value) {
        this.id = id;
        this.commandEntity = commandEntity;
        this.key = key;
        this.value = value;
    }
    //</editor-fold>
}
