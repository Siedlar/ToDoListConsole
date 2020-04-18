import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="Imie")
    private String imie;
    @Column(name="Nazwisko")
    private String nazwisko;
    @Column(name="login")
    private String login;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="dataZalozenia",insertable = false)
    private String dataZalozenia;
    @OneToMany(mappedBy = "user" ,cascade =CascadeType.ALL,fetch=FetchType.LAZY)
private List<Tasks> listaZadan;

    public Users(String imie, String nazwisko, String login, String password, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.email = email;
        this.password = password;
    }


    public List<Tasks> getListaZadan() {
        return listaZadan;
    }

    public void setListaZadan(List<Tasks> listaZadan) {
        this.listaZadan = listaZadan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Users(String imie, String nazwisko, String login, String password) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.password = password;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dataZalozenia='" + dataZalozenia;
    }



    public Users() {
    }

}
