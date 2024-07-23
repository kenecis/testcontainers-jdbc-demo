package com.orangeandbronze.skills.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.apache.commons.lang3.ArrayUtils;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id", length = 36))
public class BinaryFile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name="image")
    private byte[] image;

    public BinaryFile(byte[] image) {
        this.image = image;
    }

    public Byte[] getImage() {
        return ArrayUtils.toObject(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BinaryFile that = (BinaryFile) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "BinaryFile{" +
                "id='" + id + '\'' +
                '}';
    }

    protected BinaryFile() {
        //Required by JPA Do not use
    }
}
