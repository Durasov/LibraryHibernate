package entity;

import javax.persistence.*;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "book", schema = "public", catalog = "libraryBase")
public class BookEntity {
    private int idB;
    private String nameB;
    private BookshelfEntity bookshelfByIdBs;
    private int idBs;

    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "id_b", nullable = false)
    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    @Basic
    @Column(name = "name_b", nullable = true, length = 60)
    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (idB != that.idB) return false;
        if (nameB != null ? !nameB.equals(that.nameB) : that.nameB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idB;
        result = 31 * result + (nameB != null ? nameB.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_bs", referencedColumnName = "id_bs")
    public BookshelfEntity getBookshelfByIdBs() {
        return bookshelfByIdBs;
    }

    public void setBookshelfByIdBs(BookshelfEntity bookshelfByIdBs) {
        this.bookshelfByIdBs = bookshelfByIdBs;
    }
}
