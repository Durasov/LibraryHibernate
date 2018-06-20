package Enity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "bookshelf", schema = "public", catalog = "libraryBase")
public class BookshelfEntity {
    private int idBs;
    private String nameBs;
    private Collection<BookEntity> booksByIdBs;

    @Id
    @Column(name = "id_bs", nullable = false)
    public int getIdBs() {
        return idBs;
    }

    public void setIdBs(int idBs) {
        this.idBs = idBs;
    }

    @Basic
    @Column(name = "name_bs", nullable = true, length = 40)
    public String getNameBs() {
        return nameBs;
    }

    public void setNameBs(String nameBs) {
        this.nameBs = nameBs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookshelfEntity that = (BookshelfEntity) o;

        if (idBs != that.idBs) return false;
        if (nameBs != null ? !nameBs.equals(that.nameBs) : that.nameBs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBs;
        result = 31 * result + (nameBs != null ? nameBs.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bookshelfByIdBs")
    public Collection<BookEntity> getBooksByIdBs() {
        return booksByIdBs;
    }

    public void setBooksByIdBs(Collection<BookEntity> booksByIdBs) {
        this.booksByIdBs = booksByIdBs;
    }
}
