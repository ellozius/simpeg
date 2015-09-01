package id.go.riau.bkd.simpeg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author edy.zulyza@gmail.com
 */
@Entity @Table(name = "table_aparatur")
public class Aparatur {
    
    @Id @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true, length = 18)
    private String nip;
    
    @Column(nullable = false, length = 150)
    private String nama;
    
    @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tgLahir;
    

    @Column(name = "tempat_lahir", nullable = false, length = 100)
    private String tplahir;
    
    @Column(name = "jenis_kelamin", nullable = false, length = 1)
    private String jenisKelamin;
    
    @OneToMany(
    cascade = CascadeType.ALL, 
    orphanRemoval = true,
    mappedBy = "aparatur"
        )
    private List<PasFoto> daftarAparatur = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgLahir() {
        return tgLahir;
    }

    public void setTgLahir(Date tgLahir) {
        this.tgLahir = tgLahir;
    }

    public String getTplahir() {
        return tplahir;
    }

    public void setTplahir(String tplahir) {
        this.tplahir = tplahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public List<PasFoto> getDaftarAparatur() {
        return daftarAparatur;
    }

    public void setDaftarAparatur(List<PasFoto> daftarAparatur) {
        this.daftarAparatur = daftarAparatur;
    }
    
    
    
}
