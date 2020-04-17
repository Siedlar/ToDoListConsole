import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tasks")
public class Tasks {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nazwaZadania")
    private String nazwaZadania;
    @Column(name="data")
    private Date data;
    @Column(name="czasTrwania")
    private int czasTrwania;

    public Tasks() {
    }

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="userID",referencedColumnName="id")
    private Users user;

    @Override
    public String toString() {
        return "Tasks{" +
                "nazwaZadania='" + nazwaZadania + '\'' +
                ", data=" + data +
                ", czasTrwania=" + czasTrwania + " " +user.getId();
    }

    public Tasks(String nazwaZadania, Date data, int czasTrwania) {
        this.nazwaZadania = nazwaZadania;
        this.data = data;
        this.czasTrwania = czasTrwania;
    }

    public Tasks(String nazwaZadania, Date data, int czasTrwania, Users user) {
        this.nazwaZadania = nazwaZadania;
        this.data = data;
        this.czasTrwania = czasTrwania;
        this.user = user;
    }

    public Tasks(int id, String nazwaZadania, Date data, int czasTrwania, Users user) {
        this.id = id;
        this.nazwaZadania = nazwaZadania;
        this.data = data;
        this.czasTrwania = czasTrwania;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwaZadania() {
        return nazwaZadania;
    }

    public void setNazwaZadania(String nazwaZadania) {
        this.nazwaZadania = nazwaZadania;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
