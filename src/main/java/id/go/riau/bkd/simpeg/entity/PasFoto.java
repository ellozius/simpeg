/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.riau.bkd.simpeg.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author student2
 */

@Entity @Table(name = "table_pasfoto")
public class PasFoto {
    
    @Id @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_aparatur", nullable = false)
    private Aparatur aparatur;
    
    @Column(name = "nama_file", nullable = false, length = 100)
    private String namaFile;
    
    @Column(name = "tanggal_upload", nullable = false)
    private Date tanggalUpload;
    
}
