package id.go.riau.bkd.simpeg.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
}
