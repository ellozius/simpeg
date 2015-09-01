package id.go.riau.bkd.simpeg.dao;

/**
 *
 * @author edy.zulyza@gmail.com
 */
import id.go.riau.bkd.simpeg.MainApp;
import id.go.riau.bkd.simpeg.entity.Aparatur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "/data/aparatur.sql"
)

public class AparaturDaoTest {

    
    @Autowired
    private AparaturDao pd;
    
    @Autowired
    private DataSource ds;
    
    @Before
    public void coba(){
        System.out.println("Menjalankan Coba");
    }
    
    @After
    public void hapusData() throws Exception {
        System.out.println("Menjalankan Hapus Setelah Test");
        String sql = "delete from table_aparatur where nip = '197606252007011003'";
        try (Connection c = ds.getConnection()) {
            c.createStatement().executeUpdate(sql);
        }
    }
    
    @Test
    public void testInsert() throws SQLException {
        System.out.println("Menjalankan Test Insert");
        Aparatur p = new Aparatur();
        p.setNip("197606252007011012");
        p.setNama("ElloziusXXX");
        p.setTgLahir(new Date());
        p.setTplahir("Bengkalis");
        p.setJenisKelamin("L");
        
        pd.save(p);
        
        String sql = "select count(*) as jumlah "
                + "from table_aparatur "
                + "where nip = '197606252007011003'";
        
        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            
            Long jumlahRow = rs.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }
    }
    
    @Test
    public void testHitung(){
        System.out.println("Menjalankan Test Hitung");
        Long jumlah = pd.count();
        Assert.assertEquals(3L, jumlah.longValue());
    }
    
    @Test
    public void testCariById(){
        System.out.println("Menjalankan Test cari ID");
        Aparatur p = pd.findOne("aa1");
        Assert.assertNotNull(p);
        Assert.assertEquals("197606252007011003", p.getNip());
        Assert.assertEquals("Ellozius", p.getNama());
        
        Aparatur px = pd.findOne("xx");
        Assert.assertNull(px);
    }
}
