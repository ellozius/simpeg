/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.riau.bkd.simpeg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author edy.zulyza@gmail.com
 */

@Entity @Table(name = "table_user")
public class User {
    
    @Id @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true, length = 18)
    private String nip;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, length = 150)
    private String nama;
    
    @Column(nullable = false, length = 1)
    private String role;
    
    @Column(nullable = false, length = 1)
    private String status;
}
